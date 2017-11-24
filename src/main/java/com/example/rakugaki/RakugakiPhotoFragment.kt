package com.example.rakugaki

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.rakugaki.databinding.FragmentRakugakiPhotoBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class RakugakiPhotoFragment : BaseFragment() {
    lateinit var binding: FragmentRakugakiPhotoBinding

    private var rakugaki: RakugakiCore? = null

    private var bgImgView: ImageView? = null

    private var viewModel: PhotoEditViewModel? = null

    private var height = 0

    private var width = 0
    private var imageHeight = 0

    private var imageWidth = 0

    private var rate = 1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRakugakiPhotoBinding.inflate(inflater, container, false)

        initView()
        setParams()

        return binding.root
    }

    private fun initView() {
        val layout: FrameLayout = binding.container
        val url = arguments.getString(EXTRA_RAKUGAKI_PHOTO)

        bgImgView = binding?.imageView

        binding.scrollview.setEnabled(false)
        binding.scrollview.requestDisallowInterceptTouchEvent(true)

        var observer = binding?.scrollview.viewTreeObserver
        val listener = object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                //描画完了時
                val h = binding?.scrollview.height
                val metrics = context.getResources().getDisplayMetrics()
                val vh = h - (80 * metrics.density).toInt()
                //val params = binding?.imageView.getLayoutParams()
                if (height < vh) {
                    height = vh
                    println("height:" + height)
                    println("imageHeight:" + imageHeight)
                    //params.height = height
                    //binding?.imageView.setLayoutParams(params)
                }
                println("rate:" + rate)

                //描画完了時
                val w = binding?.scrollview.width
                //val params = binding?.imageView.getLayoutParams()
                if (width < w) {
                    width = w
                    println("width:" + width)
                    println("imageWidth:" + imageWidth)
                    //params.height = height
                    //binding?.imageView.setLayoutParams(params)
                }
            }
        }
        observer.addOnGlobalLayoutListener(listener)

        rakugaki = RakugakiCore.create(layout)
        rakugaki?.baseUrl = url

        Picasso.with(context)
                .load(url)
                .centerInside()
                .fit()
                .placeholder(R.drawable.ic_action_cached)
                .error(R.drawable.ic_action_cached)
                .into(bgImgView, object : Callback {
                    override fun onError() {

                    }

                    override fun onSuccess() {
                        try {

                            val metrics = context.getResources().getDisplayMetrics()
                            val bar = (80 * metrics.density).toInt()

                            val iH = (binding?.imageView.drawable as BitmapDrawable).bitmap.height
                            val iW = (binding?.imageView.drawable as BitmapDrawable).bitmap.width
                            var margin = 0
                            if (iH > imageHeight) {
                                imageHeight = iH
                                println("imageHeight:" + imageHeight)

                                if(iW < iH) {
                                    //縦長

                                    val r = height.toDouble() / imageHeight.toDouble()
                                    if (rate < r) {
                                        rate = r
                                    }
                                    margin = ((iW * rate - imageWidth)/2.0).toInt()
                                }

                                val params = binding?.imageView.getLayoutParams()
                                params.height = (imageHeight * rate).toInt()
                                params.width = (imageWidth * rate).toInt()
                                binding?.imageView.setLayoutParams(params)
                            }
                            if (iW > imageWidth) {
                                imageWidth = iW
                                println("imageWidth:" + imageWidth)

                                var margin = 0
                                if(iW > iH) {
                                    //横長

                                    val r = width.toDouble() / imageWidth.toDouble()
                                    if (rate < r) {
                                        rate = r
                                    }

                                    margin = ((iH * rate - imageHeight)/2.0).toInt()
                                }

                                val params = binding?.imageView.getLayoutParams()
                                params.height = (imageHeight * rate).toInt()
                                params.width = (imageWidth * rate).toInt()
                                binding?.imageView.setLayoutParams(params)
                            }
                            rakugaki?.isEnabled = true
                        } catch (e: Exception) {
                            println("error:" + e.message)
                        }
                    }
                })
    }

    override fun onResume() {
        super.onResume()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onPause() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        super.onPause()
    }

    private fun setParams() {
        // FIXME: 隠蔽必要かも
        val KEY_PHOTO_ID = "key_photo_id"
        val KEY_MESSAGE_ID = "key_message_id"
        val messegeid = arguments.getString(KEY_MESSAGE_ID)
        val photoid = arguments.getLong(KEY_PHOTO_ID)

        val photo = Photo.getPhoto(photoid)

        viewModel = PhotoEditViewModel(photo, rakugaki)
        binding.viewModel = viewModel
        binding.viewModel.callback = object : PhotoEditViewModel.Callback {
            override fun enableCancel() {
                (activity as RakugakiPhotoActivity).enableCancel()
            }

            override fun enableBack() {
                (activity as RakugakiPhotoActivity).enableBack()
            }
        }
        binding.fragment = this
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onRakugakiTapEvent(event: RakugakiTapEvent) {
        when (event.event) {
            RakugakiTapEvent.RakugakiEvent.TEXTABLE ->{
                rakugaki?.freehandEnd()
                val v = event.view as TextCanvasView
                rakugaki?.resumeText(v)

                viewModel?.setCharactable()
                viewModel?.setColor(v.color, context)
                (activity as RakugakiPhotoActivity).enableCancel()

                val handler = Handler()
                handler.postDelayed(object :Runnable{
                    override fun run() {
                        rakugaki?.freetext?.isFocusable = true
                        rakugaki?.freetext?.isFocusableInTouchMode = true
                        rakugaki?.freetext?.requestFocus()

                        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.showSoftInput(rakugaki?.freetext, InputMethodManager.SHOW_IMPLICIT)
                        rakugaki?.fixedFreehand()
                    }
                },500)
            }
            RakugakiTapEvent.RakugakiEvent.DRAGGING -> {
                viewModel?.toMenu()
                (activity as RakugakiPhotoActivity).disableToolbar()
                viewModel?.deletable = true

                val y = binding.delete.y + binding.deleteArea.y
                val position_y = event.view.y + event.view.height

                if (position_y > y) {
                    binding?.deleteImage.background = ContextCompat.getDrawable(context, R.drawable.red_circle)
                    binding?.deleteText.setTextColor(Color.RED)
                } else {
                    binding?.deleteImage.background = ContextCompat.getDrawable(context, R.drawable.white_border_circle)
                    binding?.deleteText.setTextColor(Color.WHITE)
                }
            }
            RakugakiTapEvent.RakugakiEvent.RELEASED -> {
                val rakugaki = rakugaki ?: return

                //リリースが行われた
                (activity as RakugakiPhotoActivity).enableToolbar()

                viewModel?.deletable = false

                if (!rakugaki.isFreehandNull()) {
                    val end = rakugaki.freehandEnd()
                    if (!end) {
                        rakugaki.removeLast()
                    }
                } else {
                    rakugaki.freetextEnd()
                }

                val y = binding.delete.y + binding.deleteArea.y
                val position_y = event.view.y + event.view.height

                if (position_y > y) {
                    rakugaki.remove(event.view)
                }
                //背景にフォーカスを当ててキーボードを隠す
                bgImgView?.isFocusableInTouchMode = true
                // ソフトキーボードを非表示にする
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view?.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
    }

    fun onClickDone(view: View) {
        val rakugaki = rakugaki ?: return
        val bgImgView = bgImgView ?: return

        //背景にフォーカスを当ててキーボードを隠す
        bgImgView.isFocusableInTouchMode = true

        rakugaki.callback = object : RakugakiCore.Callback {
            override fun canSave() {
                rakugaki.callback = null
            }
        }

        if (!rakugaki.isFreehandNull()) {
            val end = rakugaki.freehandEnd()
            if (!end) {
                rakugaki.removeLast()
            }
        } else {
            rakugaki.freetextEnd()
        }
        rakugaki?.movable()
        viewModel?.toMenu()
        (activity as RakugakiPhotoActivity).enableBack()

        // ソフトキーボードを非表示にする
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun onClickCancel(view: View) {
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.requestFocus()
        val rakugaki = rakugaki ?: return
        rakugaki.callback = object : RakugakiCore.Callback {
            override fun canSave() {
                rakugaki.removeLast()
                rakugaki.callback = null
            }
        }
        if (!rakugaki.isFreehandNull()) {
            val end = rakugaki.freehandEnd()
            if (!end) {
                rakugaki.removeLast()
            }
        } else {
            rakugaki.freetextEnd()
        }
        rakugaki?.movable()
        viewModel?.toMenu()
    }

    //画像を合成して保存 結果をintentで返却
    fun saveImageAndDone(view: View) {
        val bgImgView = bgImgView ?: return
        val rakugaki = rakugaki ?: return

        if (!rakugaki.isFreehandNull()) {
            rakugaki.freehandEnd()
        } else {
            rakugaki.freetextEnd()
        }

        //画像化して再設定
        val url: String? = rakugaki.saveImage(bgImgView)

        val intent = Intent()
        intent.putExtra(RakugakiPhoto.KEY_RAKUGAKI_PHOTO, url)
        activity.setResult(Activity.RESULT_OK, intent)
        activity.finish()
    }

    companion object {

        val EXTRA_RAKUGAKI_PHOTO = "extra_rakugaki_photo"

        fun newInstance(url: String): RakugakiPhotoFragment {
            val fragment = RakugakiPhotoFragment()
            val args = Bundle()
            args.putString(EXTRA_RAKUGAKI_PHOTO, url)
            fragment.arguments = args
            return fragment
        }
    }

}

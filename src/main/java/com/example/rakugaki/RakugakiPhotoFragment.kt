package com.example.rakugaki

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.rakugaki.databinding.FragmentRakugakiPhotoBinding
import com.squareup.picasso.Picasso
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class RakugakiPhotoFragment : BaseFragment() {

    lateinit var binding: FragmentRakugakiPhotoBinding

    private var rakugaki: RakugakiCore? = null

    private var bgImgView: ImageView? = null

    private var viewModel: PhotoEditViewModel? = null

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

        Picasso.with(context)
                .load(url)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_action_cached)
                .error(R.drawable.ic_action_cached)
                .into(bgImgView)

        rakugaki = RakugakiCore.create(layout)
        rakugaki?.baseUrl = url
    }

    override fun onResume() {
        super.onResume()
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }
    }

    override fun onPause() {
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this)
        }
        super.onPause()
    }

    private fun setParams() {
        // FIXME:
//        val messegeid = arguments.getString(ImagePagerFragment.KEY_MESSAGE_ID)
        val messegeid = "hoge"
//        val photoid = arguments.getLong(ImagePagerFragment.KEY_PHOTO_ID)
        val photoid: Long = 1
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
        when(event.event){
            RakugakiTapEvent.RakugakiEvent.DRAGGING ->{
                (activity as RakugakiPhotoActivity).disableToolbar()
                viewModel?.deletable = true

                val y = binding.delete.y + binding.deleteArea.y
                val position_y = event.view.y + event.view.height

                if (position_y > y) {
                    binding?.deleteImage.background = ContextCompat.getDrawable(context, R.drawable.red_circle)
                    binding?.deleteText.setTextColor(Color.RED)
                }else{
                    binding?.deleteImage.background = ContextCompat.getDrawable(context, R.drawable.white_border_circle)
                    binding?.deleteText.setTextColor(Color.WHITE)
                }
            }
            RakugakiTapEvent.RakugakiEvent.RELEASED  ->{
                //リリースが行われた
                (activity as RakugakiPhotoActivity).enableToolbar()

                viewModel?.deletable = false

                val y = binding.delete.y + binding.deleteArea.y
                val position_y = event.view.y + event.view.height

                if (position_y > y) {
                    rakugaki?.remove(event.view)
                }
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
            if(!end){
                rakugaki.removeLast()
            }
        } else {
            rakugaki.freetextEnd()
        }
        viewModel?.toMenu()
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
            if(!end){
                rakugaki.removeLast()
            }
        } else {
            rakugaki.freetextEnd()
        }
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

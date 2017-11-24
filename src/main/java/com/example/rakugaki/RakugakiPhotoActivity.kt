package com.example.rakugaki

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.view.View
import com.example.rakugaki.databinding.ActivityRakugakiPhotoBinding

class RakugakiPhotoActivity : BaseActivity() {


    lateinit var binding: ActivityRakugakiPhotoBinding

    private var fragment: RakugakiPhotoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rakugaki_photo)

        binding.toolbar?.title = ""
        initBackToolbar(binding.toolbar)
        binding.activity = this
        binding.rakugakiPhotoCancel?.visibility = View.GONE
        binding.rakugakiPhotoDone?.visibility = View.GONE

        val url = intent.getStringExtra(RakugakiPhoto.EXTRA_RAKUGAKI_PHOTO)

        if (savedInstanceState == null) {
            fragment = RakugakiPhotoFragment.newInstance(url)
            replaceFragment(fragment!!, R.id.content_view)
        } else {
            fragment = supportFragmentManager.findFragmentById(R.id.content_view) as RakugakiPhotoFragment
        }
    }

    fun onClickDone(view: View) {
        fragment?.onClickDone(view)
        enableBack()
    }

    fun onClickCancel(view: View) {
        fragment?.onClickCancel(view)
        enableBack()
    }

    fun enableCancel(){
        binding?.toolbar?.title = ""
        initTopToolbar(binding?.toolbar)
        binding?.rakugakiPhotoCancel?.visibility = View.VISIBLE
        binding?.rakugakiPhotoDone?.visibility = View.VISIBLE
    }

    fun enableBack(){
        binding?.toolbar?.title = ""
        initBackToolbar(binding?.toolbar)
        binding?.rakugakiPhotoCancel?.visibility = View.GONE
        binding?.rakugakiPhotoDone?.visibility = View.GONE
    }

    fun enableToolbar(){
        binding?.toolbar?.title = ""
        enableBack()
        val color = ContextCompat.getColor(this, R.color.main)
        binding?.toolbar?.setBackgroundColor(color)
    }

    fun disableToolbar(){
        binding?.toolbar?.title = ""
        hideToolbar()
        binding?.rakugakiPhotoCancel?.visibility = View.GONE
        binding?.rakugakiPhotoDone?.visibility = View.GONE
        binding?.toolbar?.setBackgroundColor(Color.BLACK)
    }

    override fun onBackPressed() {

        AlertDialog.Builder(this, R.style.DialogTheme)
                .setTitle("書き込みの終了")
                .setMessage("現在の編集内容を破棄してもよろしいですか？")
                .setPositiveButton("破棄", object: DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        super@RakugakiPhotoActivity.onBackPressed()
                    }
                })
                .setNegativeButton("キャンセル",object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                    }
                })
                .show()
    }

    companion object {
        fun createIntent(context: Context, bundle: Bundle): Intent {
            val intent = Intent(context, RakugakiPhotoActivity::class.java)
            intent.putExtras(bundle)
            return intent
        }

    }

}

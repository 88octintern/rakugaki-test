package com.example.rakugaki

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import android.view.View
import com.example.rakugaki.databinding.ActivityRakugakiPhotoBinding

class RakugakiPhotoActivity : BaseActivity() {

    private var binding: ActivityRakugakiPhotoBinding? = null

    private var fragment: RakugakiPhotoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rakugaki_photo)

        binding?.toolbar?.title = ""
        initBackToolbar(binding?.toolbar)
        binding?.activity = this
        binding?.rakugakiPhotoCancel?.visibility = View.GONE
        binding?.rakugakiPhotoDone?.visibility = View.GONE

        val url = intent.getStringExtra(RakugakiPhoto.EXTRA_RAKUGAKI_PHOTO)

        if (savedInstanceState == null) {
            fragment = RakugakiPhotoFragment.newInstance(url)
            replaceFragment(fragment, R.id.content_view)
        } else {
            fragment = supportFragmentManager.findFragmentById(R.id.content_view) as RakugakiPhotoFragment
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> finish()
        }
        return true
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
        binding?.toolbar?.setBackgroundColor(Color.BLACK)
    }

    companion object {
        fun createIntent(context: Context, bundle: Bundle): Intent {
            val intent = Intent(context, RakugakiPhotoActivity::class.java)
            intent.putExtras(bundle)
            return intent
        }

    }
}

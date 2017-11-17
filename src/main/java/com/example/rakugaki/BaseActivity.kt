package com.example.rakugaki

import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Created by 88oct on 2017/11/10.
 */
abstract class BaseActivity: AppCompatActivity() {

    fun initBackToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)

        val bar = supportActionBar
        if (bar != null) {
            bar.title = toolbar?.title
            bar.setDisplayHomeAsUpEnabled(true)
            bar.setDisplayShowHomeEnabled(true)
            bar.setDisplayShowTitleEnabled(true)
            bar.setHomeButtonEnabled(true)
        }
    }

    fun replaceFragment(fragment: Fragment?, @IdRes @LayoutRes layoutResId: Int) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(layoutResId, fragment, fragment?.javaClass?.getSimpleName())
        ft.commit()
    }

    fun hideToolbar() {
        val bar = supportActionBar
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(false)
            bar.setDisplayShowHomeEnabled(false)
            bar.setDisplayShowTitleEnabled(false)
            bar.setHomeButtonEnabled(false)
        }
    }

    fun initTopToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)

        val bar = supportActionBar
        if (bar != null) {
            bar.title = toolbar?.title
            bar.setDisplayHomeAsUpEnabled(false)
            bar.setDisplayShowHomeEnabled(true)
            bar.setDisplayShowTitleEnabled(true)
            bar.setHomeButtonEnabled(true)
        }
    }
}
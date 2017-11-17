package com.example.rakugaki

import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by 88oct on 2017/11/10.
 */
object DataBindingHelper {
    @JvmStatic
    @BindingAdapter("photoImageUrl")
    fun setPhotoImageUrl(imageView: ImageView, imageUrl: String?) {
        setImageUrl(imageView, imageUrl, R.color.gray200)
    }

    private fun setImageUrl(imageView: ImageView, imageUrl: String?,
                            @DrawableRes placeholderResId: Int) {
        if (TextUtils.isEmpty(imageUrl)) {
            imageView.setImageDrawable(
                    ContextCompat.getDrawable(imageView.context, placeholderResId))
        } else {
            Picasso.with(imageView.context)
                    .load(imageUrl)
                    .placeholder(placeholderResId)
                    .error(placeholderResId)
                    .into(imageView)
        }
    }
}
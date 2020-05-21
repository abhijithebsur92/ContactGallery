package com.sample.phonebook.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sample.phonebook.R
import com.sample.phonebook.common.ui.ImageLoader


/**
 * Utility class for Binding Adapters
 *
 */
@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (url != null) {
        val imgLoader = ImageLoader(imageView.context.applicationContext)

        imgLoader.displayImage(url, R.mipmap.ic_launcher, imageView)
    }
}

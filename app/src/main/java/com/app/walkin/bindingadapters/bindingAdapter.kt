package com.app.walkin.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.walkin.R
import com.app.walkin.extensions.loadImage

object bindingAdapter {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view: ImageView?, url: String?) {
        view?.loadImage(url, R.drawable.notavailable)
    }

}
package com.app.walkin.extensions

import android.widget.ImageView
import com.app.walkin.R
import com.app.walkin.constants.BaseAPIConstants
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url:String?, placeholder: Int){
    if (url!=null){
        Glide.with(context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.notavailable)
            ).into(this)
    }
}

fun ImageView.loadImage(url: String?) {
    if (url != null) {
        Glide.with(context)
            .load(url)
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}
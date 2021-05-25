package com.appdevpwl.rickyandmortyapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(image: ImageView, url: String) {
            Glide.with(image)
                .load(url)
                .circleCrop()
                .into(image)

        }
    }

}
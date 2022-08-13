package com.example.newsapp.util

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setIconCircle")
fun setIconCircle(imageView: AppCompatImageView, icon: Int) {
    imageView.loadIconWithGlideCircle(icon)
}

@BindingAdapter("setIcon")
fun setIcon(imageView: AppCompatImageView, icon: Drawable) {
    //if (icon != 0) {

        imageView.setImageDrawable(icon)
    //}
}
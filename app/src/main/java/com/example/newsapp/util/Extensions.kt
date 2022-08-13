package com.example.newsapp.util

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun AppCompatImageView.loadIconWithGlideCircle(icon: Int) {
    com.example.newsapp.di.GlideApp.with(this)
        .load(icon)
        .apply(AppGlideExtensions.circle())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun RecyclerView.disableAnimationChanges() {
    (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
}

fun NestedScrollView.scrollToTop() {
    smoothScrollTo(0, 0)
}

fun Activity.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.showLongToast(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_LONG).show()
}

fun Activity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.showShortToast(resourceId: Int) {
    Toast.makeText(this, resourceId, Toast.LENGTH_SHORT).show()
}
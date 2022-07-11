package com.example.newsapp.util.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    disableDarkMode()
    window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
  }

  private fun disableDarkMode() {
    try {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
      } catch (ignored: Exception) {
    }
  }
}

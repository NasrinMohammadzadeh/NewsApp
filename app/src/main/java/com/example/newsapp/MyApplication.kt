package com.example.newsapp

import android.app.Application
import com.example.newsapp.preferences.GetIsDarkThemePrefs
import com.example.newsapp.util.ThemeUtils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    @Inject
    lateinit var getIsDarkThemePrefs: GetIsDarkThemePrefs

    override fun onCreate() {
        super.onCreate()
        val isDarkTheme = getIsDarkThemePrefs()
        ThemeUtils.changeTheme(isDarkTheme)
    }
}
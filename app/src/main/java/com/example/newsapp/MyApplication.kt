package com.example.newsapp

import android.app.Application
import com.example.newsapp.preferences.GetIsDarkThemePrefs
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    @Inject
    lateinit var getIsDarkThemePrefs: GetIsDarkThemePrefs
}
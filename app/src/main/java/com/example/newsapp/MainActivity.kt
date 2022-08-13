package com.example.newsapp

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.newsapp.util.ThemeUtils
import com.example.newsapp.util.base.BottomNavigationActivity
import com.example.newsapp.util.showLongToast
import com.example.newsapp.util.showShortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BottomNavigationActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        initView()
    }


    override fun changeTheme() {
        val isDarkTheme = viewModel.isDarkTheme()
        viewModel.changeTheme(!isDarkTheme)
        ThemeUtils.changeTheme(!isDarkTheme)
    }

    override fun showLongMessage(resourceId: Int) {
        showLongToast(resourceId)
    }

    override fun showLongMessage(message: String) {
        showLongToast(message)
    }

    override fun showShortMessage(resourceId: Int) {
        showShortToast(resourceId)
    }

    override fun showShortMessage(message: String) {
        showShortToast(message)
    }

    override fun showRemoteMessage(serverErrorMessage: String?, errorMessage: Int) {
        if (serverErrorMessage == null) {
            if (errorMessage != 0)
                showLongMessage(errorMessage)
        } else showLongMessage(serverErrorMessage)
    }

    private fun initView() {
        if (viewModel.isDarkTheme())
            darkStatusBar()
        else lightStatusBar()
    }

    @Suppress("DEPRECATION")
    private fun lightStatusBar() {
        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.systemUiVisibility =
                view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    @Suppress("DEPRECATION")
    private fun darkStatusBar() {
        val view = window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.systemUiVisibility =
                view.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }
}
package com.example.newsapp.util

interface MainHelper {

    fun showLongMessage(resourceId: Int)

    fun showLongMessage(message: String)

    fun showShortMessage(resourceId: Int)

    fun showShortMessage(message: String)

    fun showRemoteMessage(serverErrorMessage: String?, errorMessage: Int)

    fun changeTheme()
}

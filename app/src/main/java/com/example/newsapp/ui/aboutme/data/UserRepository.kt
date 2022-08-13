package com.example.newsapp.ui.aboutme.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userLocalDataSource: UserLocalDataSource) {

    fun getUserProfileLocal() = userLocalDataSource.getUserProfile()
}

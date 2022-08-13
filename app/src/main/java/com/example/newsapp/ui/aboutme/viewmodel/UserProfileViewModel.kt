package com.example.newsapp.ui.aboutme.viewmodel

import com.example.newsapp.preferences.GetIsDarkThemeFlowPrefs
import com.example.newsapp.ui.aboutme.data.UserRepository
import com.example.newsapp.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    getUserProfileLocal: UserRepository,
    getIsDarkThemeFlowPrefs: GetIsDarkThemeFlowPrefs
) : BaseViewModel() {

    val userProfile = getUserProfileLocal.getUserProfileLocal()

    val getIsDarkThemeFlow = getIsDarkThemeFlowPrefs()

    override fun getData() {}
}

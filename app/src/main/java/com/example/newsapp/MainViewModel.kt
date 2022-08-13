package com.example.newsapp

import androidx.lifecycle.viewModelScope
import com.example.newsapp.preferences.DoUpdateIsDarkThemePrefs
import com.example.newsapp.preferences.GetIsDarkThemePrefs
import com.example.newsapp.preferences.PreferencesDataStore
import com.example.newsapp.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getIsDarkThemePrefs: GetIsDarkThemePrefs,
    private val doUpdateIsDarkThemePrefs: DoUpdateIsDarkThemePrefs
) : BaseViewModel() {

    fun isDarkTheme() = getIsDarkThemePrefs()

    fun changeTheme(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            doUpdateIsDarkThemePrefs(value)
        }
    }

    override fun getData() {}
}

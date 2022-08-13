package com.example.newsapp.preferences

import javax.inject.Inject

class DoUpdateIsDarkThemePrefs @Inject constructor(
    private val preferencesDataStore: PreferencesDataStore
) {
    suspend operator fun invoke(value: Boolean) = preferencesDataStore.updateIsDarkTheme(value)
}

package com.example.newsapp.preferences

import javax.inject.Inject

class GetIsDarkThemeFlowPrefs @Inject constructor(
    private val preferencesDataStore: PreferencesDataStore
) {
    operator fun invoke() = preferencesDataStore.getIsDarkThemeFlow
}

package com.zhadko.mysuperwebviewapp.ui.webViewScreen

import androidx.lifecycle.ViewModel
import com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository.SharedPrefsRepository

class WebViewViewModel(
    private val sharedPreferencesRepository: SharedPrefsRepository
) : ViewModel() {

    fun getLastViewedPage(): String {
        return sharedPreferencesRepository.getLastViewedPage()
    }

    fun saveLastViewedPage(lastViewedPage: String) {
        sharedPreferencesRepository.saveLastViewedPage(lastViewedPage)
    }

}
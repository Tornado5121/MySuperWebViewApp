package com.zhadko.mysuperwebviewapp.ui.mainActivityScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository.SharedPrefsRepository

class MainActivityViewModel(
    context: Context,
    private val sharedPrefsRepository: SharedPrefsRepository
) : ViewModel() {

    val connectivityLiveData = ConnectivityLiveData(context)

    fun isFirstLaunch(): Boolean {
        return sharedPrefsRepository.isFirstLaunch()
    }

}
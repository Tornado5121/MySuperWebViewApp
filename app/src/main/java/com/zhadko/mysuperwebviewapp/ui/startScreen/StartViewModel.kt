package com.zhadko.mysuperwebviewapp.ui.startScreen

import androidx.lifecycle.ViewModel
import com.zhadko.mysuperwebviewapp.data.networkHelperRepository.NetworkHelperRepo
import com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository.SharedPrefsRepository


class StartViewModel(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val networkHelperRepo: NetworkHelperRepo
) : ViewModel() {

    fun setFirstLaunchFlagToFalse() {
        sharedPrefsRepository.setFirstLaunchFlagToFalse(false)
    }

    fun isNetworkConnected(): Boolean {
        return networkHelperRepo.isNetworkConnected()
    }

}
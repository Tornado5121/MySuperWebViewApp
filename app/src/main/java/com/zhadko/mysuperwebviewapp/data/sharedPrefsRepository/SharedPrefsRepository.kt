package com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository

interface SharedPrefsRepository {

    fun isFirstLaunch(): Boolean
    fun setFirstLaunchFlagToFalse(isFirstLaunch: Boolean)

    fun saveLastViewedPage(lastViewedPage: String)
    fun getLastViewedPage(): String

}
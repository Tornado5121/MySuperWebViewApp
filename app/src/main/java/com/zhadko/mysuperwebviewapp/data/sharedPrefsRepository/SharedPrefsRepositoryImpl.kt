package com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


private const val SHARED_PREF_FILE_NAME = "SharedPrefs"
private const val LAST_VIEWED_PAGE_ID = "last_viewed_page"
private const val IS_FIRST_LAUNCH = "is_first_launch"

class SharedPrefsRepositoryImpl(
    context: Context
) : SharedPrefsRepository {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

    override fun isFirstLaunch(): Boolean {
        return sharedPref.getBoolean(IS_FIRST_LAUNCH, true)
    }

    override fun setFirstLaunchFlagToFalse(isFirstLaunch: Boolean) {
        sharedPref.edit {
            putBoolean(IS_FIRST_LAUNCH, isFirstLaunch)
        }
    }

    override fun saveLastViewedPage(lastViewedPage: String) {
        sharedPref.edit {
            putString(LAST_VIEWED_PAGE_ID, lastViewedPage)
        }
    }

    override fun getLastViewedPage(): String {
        return sharedPref.getString(LAST_VIEWED_PAGE_ID, "").toString()
    }

}
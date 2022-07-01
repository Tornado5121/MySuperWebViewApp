package com.zhadko.mysuperwebviewapp.data.networkHelperRepository

import android.content.Context
import android.net.ConnectivityManager

class NetworkHelperRepoImpl(
    private val context: Context
) : NetworkHelperRepo {

    override fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }

}
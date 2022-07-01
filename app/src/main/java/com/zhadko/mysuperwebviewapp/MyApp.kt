package com.zhadko.mysuperwebviewapp

import android.app.Application
import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal
import com.onesignal.OneSignal.setLogLevel
import com.zhadko.mysuperwebviewapp.di.dataModule
import com.zhadko.mysuperwebviewapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(dataModule, viewModelModule)
        }

        setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.ONESIGNAL_APP_ID))

        AppsFlyerLib.getInstance().init(getString(R.string.apps_flyer_dev_key), null, this);
    }

}
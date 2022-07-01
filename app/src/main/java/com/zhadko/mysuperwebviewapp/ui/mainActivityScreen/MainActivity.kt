package com.zhadko.mysuperwebviewapp.ui.mainActivityScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhadko.mysuperwebviewapp.R
import com.zhadko.mysuperwebviewapp.ui.noInternetScreen.NoInternetFragment
import com.zhadko.mysuperwebviewapp.ui.startScreen.StartFragment
import com.zhadko.mysuperwebviewapp.ui.webViewScreen.WebViewFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (mainActivityViewModel.isFirstLaunch()) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.my_fragment_container, StartFragment())
                .commit()
        }

        mainActivityViewModel.connectivityLiveData.observe(this) {
            if (!mainActivityViewModel.isFirstLaunch()) {
                if (it) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.my_fragment_container, WebViewFragment())
                        .commit()
                } else {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.my_fragment_container, NoInternetFragment())
                        .commit()
                }
            }
        }
    }

}
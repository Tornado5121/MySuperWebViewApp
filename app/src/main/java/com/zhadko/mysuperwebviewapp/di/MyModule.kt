package com.zhadko.mysuperwebviewapp.di

import com.zhadko.mysuperwebviewapp.data.networkHelperRepository.NetworkHelperRepo
import com.zhadko.mysuperwebviewapp.data.networkHelperRepository.NetworkHelperRepoImpl
import com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository.SharedPrefsRepository
import com.zhadko.mysuperwebviewapp.data.sharedPrefsRepository.SharedPrefsRepositoryImpl
import com.zhadko.mysuperwebviewapp.ui.mainActivityScreen.MainActivityViewModel
import com.zhadko.mysuperwebviewapp.ui.noInternetScreen.NoInternetViewModel
import com.zhadko.mysuperwebviewapp.ui.startScreen.StartViewModel
import com.zhadko.mysuperwebviewapp.ui.webViewScreen.WebViewViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<SharedPrefsRepository> { SharedPrefsRepositoryImpl(androidContext()) }
    single<NetworkHelperRepo> { NetworkHelperRepoImpl(androidContext()) }
}

val viewModelModule = module {
    viewModel { StartViewModel(get(), get()) }
    viewModel { MainActivityViewModel(androidContext(), get()) }
    viewModel { WebViewViewModel(get()) }
    viewModel { NoInternetViewModel() }
}
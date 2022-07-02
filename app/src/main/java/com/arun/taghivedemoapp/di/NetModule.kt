package com.arun.taghivedemoapp.di


import com.arun.taghivedemoapp.network.MainRepository
import com.arun.taghivedemoapp.network.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**
// Created by Arun Singh Rawat on 02-07-2022.
 **/

private val NetModule = module {
    factory { getHttpClient() }
    single { getRetrofit(get()) }
    single { getApiService(get()) }
    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }
}



val netModules = arrayOf(
    NetModule
)
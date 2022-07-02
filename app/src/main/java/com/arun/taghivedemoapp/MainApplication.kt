package com.arun.taghivedemoapp

import android.app.Application
import com.arun.taghivedemoapp.di.netModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
// Created by Arun Singh Rawat on 02-07-2022.
 **/

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setupDIGraph()


    }

    private fun setupDIGraph() {
        startKoin {
            androidContext(this@MainApplication)
            modules(*netModules)
        }
    }

}
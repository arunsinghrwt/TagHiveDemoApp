package com.arun.taghivedemoapp.di

import androidx.databinding.ktx.BuildConfig
import com.arun.taghivedemoapp.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
// Created by Arun Singh Rawat on 02-07-2022.
 **/

private const val timeout: Long = 30
fun getHttpClient( ): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.connectTimeout(timeout, TimeUnit.SECONDS)
    httpClient.readTimeout(timeout, TimeUnit.SECONDS)
    httpClient.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.HEADERS)
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })

    return httpClient.build()
}

fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("${"https://"}${"api.wazirx.com"}")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
fun getApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}


package com.arun.taghivedemoapp.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
// Created by Arun Singh Rawat on 02-07-2022.
 **/

interface ApiService {
    @GET("/sapi/v1/tickers/24hr")
    suspend fun guestSignup(): Response<ArrayList<ApiResponse>>
}
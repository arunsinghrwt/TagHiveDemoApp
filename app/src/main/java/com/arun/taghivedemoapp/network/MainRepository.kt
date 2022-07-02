package com.arun.taghivedemoapp.network

import androidx.lifecycle.MediatorLiveData


/**
// Created by Arun Singh Rawat on 02-07-2022.



 **/

class MainRepository (
    private val apiService: ApiService
) {

    val dataList = MediatorLiveData<ArrayList<ApiResponse>>()
    suspend fun getDataList() {
        val data = apiService.guestSignup()
        dataList.postValue(data.body())
    }

    val detailData = MediatorLiveData<ApiResponse>()
    suspend fun setDetails(apiResponse: ApiResponse) {
        detailData.postValue(apiResponse)
    }

}
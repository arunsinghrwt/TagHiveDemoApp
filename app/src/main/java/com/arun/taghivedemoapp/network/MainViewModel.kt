package com.arun.taghivedemoapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


/**
// Created by Arun Singh Rawat on 02-07-2022.
    **/

class MainViewModel(private val repository: MainRepository) : ViewModel(){
    val liveData = repository.dataList
    fun getData() {
        viewModelScope.launch {
            repository.getDataList()
        }
    }

    val liveDetails = repository.detailData
    fun setDetails(apiResponse: ApiResponse) {
        viewModelScope.launch {
            repository.setDetails(apiResponse)
        }
    }

}
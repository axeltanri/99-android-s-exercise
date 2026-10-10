package com.example.team99_android_exercise.ListingDetail

import androidx.lifecycle.ViewModel
import com.example.team99_android_exercise.Service.RetrofitClient

class ListingDetailViewModel : ViewModel(){

    private val apiService = RetrofitClient.getApiService()

}
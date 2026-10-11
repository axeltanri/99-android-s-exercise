package com.example.team99_android_exercise.ListingDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.team99_android_exercise.Model.PropertyDetail
import com.example.team99_android_exercise.Service.RetrofitClient
import kotlinx.coroutines.launch

class ListingDetailViewModel : ViewModel(){

    private val apiService = RetrofitClient.getApiService()

    private val _propertyDetail = MutableLiveData<PropertyDetail>()
    val propertyDetail: LiveData<PropertyDetail> = _propertyDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun loadPropertyDetail(id: Int){
        viewModelScope.launch {
            try {
                _propertyDetail.value = apiService.getPropertyDetail(id)
            }catch (e: Exception){
                _error.value = e.message ?: "Unknown Error"
            }
        }

    }


}
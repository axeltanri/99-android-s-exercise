package com.example.team99_android_exercise.SearchResult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.team99_android_exercise.Model.ListProperty
import com.example.team99_android_exercise.Model.PropertyDetail
import com.example.team99_android_exercise.Service.RetrofitClient
import kotlinx.coroutines.launch

class SearchResultViewModel: ViewModel() {
    private val apiService = RetrofitClient.getApiService()

    private val _listSearchResult = MutableLiveData<List<ListProperty>>()
    val listSearchResult: LiveData<List<ListProperty>> = _listSearchResult
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadSearchResult(){
        viewModelScope.launch {
            try {
                _listSearchResult.value = apiService.getProperties()
            }catch (e: Exception){
                _error.value = e.message ?: "Unknown Error"
            }
        }
    }
}
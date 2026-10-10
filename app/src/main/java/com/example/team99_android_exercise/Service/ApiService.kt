package com.example.team99_android_exercise.Service

import com.example.team99_android_exercise.Model.ListProperty
import com.example.team99_android_exercise.Model.PropertyDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/listings.json")
    suspend fun getProperties(): List<ListProperty>

    @GET("/details/{id}.json")
    suspend fun getPropertyDetail(@Path("id") id: Int): PropertyDetail
}
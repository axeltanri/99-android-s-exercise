package com.example.team99_android_exercise.Model

import com.google.gson.annotations.SerializedName

data class PropertyAttribute(
    @SerializedName("area_size")
    val areaSize: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)

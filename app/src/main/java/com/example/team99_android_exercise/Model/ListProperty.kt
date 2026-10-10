package com.example.team99_android_exercise.Model

import com.google.gson.annotations.SerializedName

data class ListProperty(
    val address: ListAddress,
    val attributes: PropertyAttribute,
    val category: String,
    @SerializedName("completed_at")
    val completedAt: String,
    val id: Int,
    val photo: String,
    @SerializedName("project_name")
    val projectName: String,
    val tenure: Int
)

data class ListAddress(
    val district: String,
    @SerializedName("street_name")
    val streetName: String
)

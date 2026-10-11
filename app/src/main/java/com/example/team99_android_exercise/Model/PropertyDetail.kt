package com.example.team99_android_exercise.Model

import com.google.gson.annotations.SerializedName

data class PropertyDetail(
    val address: DetailAddress,
    val attributes: PropertyAttribute,
    val description: String,
    val id: Int,
    val photo: String,
    @SerializedName("project_name")
    val projectName: String,

    @SerializedName("property_details")
    val propertyDetails: List<PropertyDetailItem>? = emptyList()
)

data class DetailAddress(
    @SerializedName("map_coordinates")
    val mapCoordinates: MapCoordinates,
    val title: String,
    val subtitle: String,
)

data class MapCoordinates(
    val lat: Double,
    val lng: Double,
)

data class PropertyDetailItem(
    @SerializedName("label")
    val label: String,
    @SerializedName("text")
    val text: String,
)

data class PropertyDetailAttribute(
    @SerializedName("propertyAttribute")
    val propertyAttribute: List<PropertyDetailItem>
)
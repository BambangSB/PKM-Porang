package com.example.pkmporang.model.sensor


import com.google.gson.annotations.SerializedName

data class DataSensorItem(
    @SerializedName("berat1")
    val berat1: Int,
    @SerializedName("berat2")
    val berat2: Int,
    @SerializedName("berat3")
    val berat3: Int,
    @SerializedName("berat4")
    val berat4: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("kondisi")
    val kondisi: String,
    @SerializedName("totalberat")
    val totalberat: Int,
    @SerializedName("ultrasonik")
    val ultrasonik: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)
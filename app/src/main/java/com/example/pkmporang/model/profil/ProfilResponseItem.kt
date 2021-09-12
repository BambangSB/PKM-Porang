package com.example.pkmporang.model.profil


import com.google.gson.annotations.SerializedName

data class ProfilResponseItem(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("telepon")
    val telepon: String,
    @SerializedName("updated_at")
    val updatedAt: String
)
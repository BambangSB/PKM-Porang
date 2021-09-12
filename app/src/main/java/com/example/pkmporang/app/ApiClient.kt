package com.example.pkmporang.app

import com.example.pkmporang.model.LoginResponse
import com.example.pkmporang.model.profil.ProfilResponse
import com.example.pkmporang.model.profil.ProfilResponseItem
import com.example.pkmporang.model.sensor.DataSensor
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @FormUrlEncoded
    @POST("login") //API Untuk Login
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<LoginResponse>

    @GET("keluar") //Api untuk data sensor masuk
    fun sensor(

    ): Call<DataSensor>

    @GET("profil")
    fun profil(
//        @Field("name") name: String,
//        @Field("email") email: String,
//        @Field("telepon") telepon: String,
//        @Field("alamat") alamat: String
    ): Call<ProfilResponse>
}
package com.example.mypingoceanapplication

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyApi {

    @POST("/auth")
    suspend fun getToken(@Body login: Login): Response<LoginResponse>

    @GET("profile")
    suspend fun getProfile(@Header("Authorization") authToken: String): Response<ProfileResponse>
}
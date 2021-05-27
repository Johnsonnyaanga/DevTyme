package com.vickikbt.devtyme.data.network

import com.vickikbt.devtyme.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("users/current")
    suspend fun fetchUserProfile(@Header("Authorization") token: String): Response<User>

}
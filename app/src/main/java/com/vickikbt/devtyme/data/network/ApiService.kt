package com.vickikbt.devtyme.data.network

import com.vickikbt.devtyme.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("users/current")
    suspend fun fetchCurrentUserProfile(@Header("Authorization") token: String): Response<UserResponse>

}
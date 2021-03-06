package com.vickikbt.devtyme.data.network

import com.vickikbt.devtyme.models.LeadersResponse
import com.vickikbt.devtyme.models.SummaryResponse
import com.vickikbt.devtyme.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("users/current")
    suspend fun fetchCurrentUserProfile(@Header("Authorization") token: String): Response<UserResponse>

    @GET("users/current/summaries")
    suspend fun fetchUserSummaries(
        @Header("Authorization") token: String,
        @Query("start") start: String,
        @Query("end") end: String,
        @Query("range") range: String? = null
    ): Response<SummaryResponse>

    @GET("leaders")
    suspend fun fetchLeaderBoard(
        @Header("Authorization") token: String,
        @Query("page") page: Int? = null
    ): LeadersResponse

}
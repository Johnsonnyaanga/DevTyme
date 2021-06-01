package com.vickikbt.devtyme.repository

import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.Board
import com.vickikbt.devtyme.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class BoardRepository @Inject constructor(
    private val apiService:ApiService,
    private val appDatabase: AppDatabase
):SafeApiRequest(){
    private val accessTokenDao = appDatabase.accessTokenDao()

    suspend fun fetchLeaderBoard(): Flow<Board> {
        val token = "Bearer ${getAccessToken().accessToken}"
        val networkResponse=safeApiRequest {
            apiService.fetchLeaderBoard(
                token=token
            )
        }
        return flowOf(networkResponse)

    }

    private suspend fun getAccessToken() = accessTokenDao.getAccessToken().take(1).toList()[0]

}
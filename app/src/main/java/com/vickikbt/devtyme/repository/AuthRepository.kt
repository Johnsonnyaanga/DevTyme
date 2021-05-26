package com.vickikbt.devtyme.repository

import androidx.lifecycle.MutableLiveData
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.AccessToken
import com.vickikbt.devtyme.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) : SafeApiRequest() {

    private val accessTokenMutableLiveData = MutableLiveData<AccessToken>()

    init {
        accessTokenMutableLiveData.observeForever { accessToken ->
            saveAccessToken(accessToken)
        }
    }

    suspend fun getNewAccessToken(code: String): Flow<AccessToken> {
        val response = safeApiRequest { apiService.getNewAccessToken(code = code) }
        accessTokenMutableLiveData.postValue(response)
        return flowOf(response)
    }

    private fun saveAccessToken(accessToken: AccessToken) {

    }

}
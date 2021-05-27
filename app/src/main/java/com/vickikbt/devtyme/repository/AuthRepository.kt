package com.vickikbt.devtyme.repository

import androidx.lifecycle.MutableLiveData
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.AuthApiService
import com.vickikbt.devtyme.models.AccessToken
import com.vickikbt.devtyme.utils.Coroutines
import com.vickikbt.devtyme.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApiService: AuthApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val accessTokenDao = appDatabase.accessTokenDao()

    private val accessTokenMutableLiveData = MutableLiveData<AccessToken>()

    init {
        accessTokenMutableLiveData.observeForever { accessToken ->
            Coroutines.io { saveAccessToken(accessToken) }
        }
    }

    suspend fun fetchNewAccessToken(code: String): Flow<AccessToken> {
        val response = safeApiRequest { authApiService.fetchNewAccessToken(code = code) }
        accessTokenMutableLiveData.postValue(response)
        return flowOf(response)
    }

    fun getAccessToken()=accessTokenDao.getAccessToken()

    suspend fun revokeAccessToken(){
        val token=getAccessToken().take(1).toList()[0]
        safeApiRequest { authApiService.revokeAccessToken(accessToken = token.accessToken) }
    }

    suspend fun deleteAccessToken()=accessTokenDao.deleteAccessToken()

    private suspend fun saveAccessToken(accessToken: AccessToken) =
        accessTokenDao.saveAccessToken(accessToken)


    suspend fun isUserLoggedIn()=accessTokenDao.isUserLoggedIn()>0

}
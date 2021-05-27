package com.vickikbt.devtyme.repository

import androidx.lifecycle.MutableLiveData
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.User
import com.vickikbt.devtyme.utils.Coroutines
import com.vickikbt.devtyme.utils.SafeApiRequest
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val userDao = appDatabase.userDao()

    private val currentUserMutableLiveData = MutableLiveData<User>()

    init {
        currentUserMutableLiveData.observeForever { user ->
            Coroutines.io { saveUser(user) }
        }
    }

    suspend fun fetchCurrentUser(accessToken: String) {
        val token = "Bearer $accessToken"

        val response = safeApiRequest { apiService.fetchCurrentUserProfile(token) }
        currentUserMutableLiveData.value = response.user
    }

    fun getCurrentUser() = userDao.getUser()

    private suspend fun saveUser(user: User) = userDao.saveUser(user)

}
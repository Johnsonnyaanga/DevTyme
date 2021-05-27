package com.vickikbt.devtyme.ui.fragment.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vickikbt.devtyme.repository.AuthRepository
import com.vickikbt.devtyme.repository.UserRepository
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    var stateListener: StateListener? = null

    init {

    }

    fun fetchNewAccessToken(code: String) {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val response = authRepository.fetchNewAccessToken(code)
                response.collect { accessToken ->
                    //stateListener?.onSuccess("Access token fetched: $accessToken")
                    fetchCurrentUser(accessToken.accessToken)
                }
                return@launch
            } catch (e: ApiException) {
                stateListener?.onError(e, "An error occurred")
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e)
                return@launch
            }
        }
    }

    fun isUserLoggedIn() = liveData {
        try {
            emit(authRepository.isUserLoggedIn())
        } catch (e: Exception) {
            stateListener?.onError(e)
            return@liveData
        }
    }

    private fun fetchCurrentUser(accessToken: String) {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val response = userRepository.fetchCurrentUser(accessToken)
                stateListener?.onSuccess("Current user fetched")
            } catch (e: ApiException) {
                stateListener?.onError(e)
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e, "An error occurred")
                return@launch
            }
        }
    }


}
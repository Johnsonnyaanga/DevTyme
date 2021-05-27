package com.vickikbt.devtyme.ui.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.devtyme.models.User
import com.vickikbt.devtyme.repository.AuthRepository
import com.vickikbt.devtyme.repository.UserRepository
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) :
    ViewModel() {

    var stateListener: StateListener? = null

    private val _currentUser = MutableLiveData<User>()
    val currentUser = _currentUser

    init {
        getCurrentUser()
    }

    private fun getCurrentUser() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val response = userRepository.getCurrentUser()
                response.collect { user ->
                    _currentUser.value = user
                    stateListener?.onSuccess("Current user: $user")
                }
                return@launch
            } catch (e: ApiException) {
                stateListener?.onError(e)
                return@launch
            } catch (e: Exception) {
                stateListener?.onError(e, "An error occurred")
                return@launch
            }
        }
    }

    fun revokeToken() {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                authRepository.revokeAccessToken()
                authRepository.deleteAccessToken()
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

}
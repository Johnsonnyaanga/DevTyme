package com.vickikbt.devtyme.ui.fragment.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.devtyme.repository.AuthRepository
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    var stateListener: StateListener? = null


    fun getNewAccessToken(code: String) {
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val response = authRepository.getNewAccessToken(code)
                response.collect { accessToken ->
                    stateListener?.onSuccess("Access token fetched: $accessToken")

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

}
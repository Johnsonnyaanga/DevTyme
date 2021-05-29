package com.vickikbt.devtyme.ui.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.vickikbt.devtyme.models.Summary
import com.vickikbt.devtyme.models.User
import com.vickikbt.devtyme.repository.AuthRepository
import com.vickikbt.devtyme.repository.SummaryRepository
import com.vickikbt.devtyme.repository.UserRepository
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.Helpers.getCurrentDateTime
import com.vickikbt.devtyme.utils.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository,
    private val summaryRepository: SummaryRepository
) : ViewModel() {

    var stateListener: StateListener? = null

    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> = _currentUser

    /*private val _summary = MutableLiveData<List<Summary>>()
    val summary: LiveData<List<Summary>> = _summary*/

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

    fun getSummary(start: String = getCurrentDateTime(), range:String?=null)= liveData {
        stateListener?.onLoading()

        //viewModelScope.launch {
            try {
                val response = summaryRepository.fetchSummary(start, range)
                response.collect { summaryResponse ->
                    emit(summaryResponse.summary)
                    stateListener?.onSuccess("Fetched summary: $summaryResponse")
                }
                return@liveData
            } catch (e: ApiException) {
                stateListener?.onError(e, "An error occurred")
                return@liveData
            } catch (e: Exception) {
                stateListener?.onError(e)
                return@liveData
            }
        //}
    }

}
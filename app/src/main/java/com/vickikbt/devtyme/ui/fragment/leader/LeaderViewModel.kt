package com.vickikbt.devtyme.ui.fragment.leader

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.devtyme.models.Leaders
import com.vickikbt.devtyme.repository.BoardRepository
import com.vickikbt.devtyme.repository.UserRepository
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LeaderViewModel @ViewModelInject constructor(
    private val boardRepository: BoardRepository,
) :ViewModel() {
    var stateListener: StateListener? = null


    private val _board = MutableLiveData<Leaders>()
    val board: LiveData<Leaders> = _board

    init {
        fetchLeaderBoard()
    }

    private fun fetchLeaderBoard(){
        stateListener?.onLoading()

        viewModelScope.launch {
            try {
                val response = boardRepository.fetchLeaderBoard()
                response.collect {
                    _board.value= it
                    stateListener?.onSuccess("Current user")
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
}
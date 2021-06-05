package com.vickikbt.devtyme.ui.fragment.board

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vickikbt.devtyme.repository.BoardRepository

class BoardViewModel @ViewModelInject constructor(private val boardRepository: BoardRepository) :
    ViewModel() {

    fun fetchLeaderBoard() = boardRepository.fetchLeaderBoard().cachedIn(viewModelScope)

}
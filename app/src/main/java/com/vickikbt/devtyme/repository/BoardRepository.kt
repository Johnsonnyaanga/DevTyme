package com.vickikbt.devtyme.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.Leader
import com.vickikbt.devtyme.paging.BoardPagingSource
import com.vickikbt.devtyme.utils.Constants.DEFAULT_PAGE_SIZE
import com.vickikbt.devtyme.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BoardRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    fun fetchLeaderBoard(): Flow<PagingData<Leader>> {
        val pagingConfig = PagingConfig(pageSize = DEFAULT_PAGE_SIZE)
        val leaderPagingSource = BoardPagingSource(apiService, appDatabase)

        val pager = Pager(config = pagingConfig, pagingSourceFactory = { leaderPagingSource })

        return pager.flow//.cachedIn(viewModelScope)
    }

}
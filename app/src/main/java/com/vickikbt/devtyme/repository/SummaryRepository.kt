package com.vickikbt.devtyme.repository

import androidx.lifecycle.MutableLiveData
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.SummaryResponse
import com.vickikbt.devtyme.utils.Coroutines
import com.vickikbt.devtyme.utils.SafeApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class SummaryRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val summaryMutableLiveData = MutableLiveData<SummaryResponse>()

    private val summariesDao = appDatabase.summaryDao()
    private val accessTokenDao = appDatabase.accessTokenDao()

    init {
        summaryMutableLiveData.observeForever { summary ->
            Coroutines.io { saveSummary(summary) }
        }
    }

    suspend fun fetchSummary(start: String): Flow<SummaryResponse> {
        val token = "Bearer ${getAccessToken().accessToken}"
        val isSummaryCached = isSummaryCached(start)
        val networkResponse = safeApiRequest {
            apiService.fetchUserSummaries(
                start = start,
                end = start,
                token = token
            )
        }
        val cacheResponse = summariesDao.getSummary(start)


        return if (isSummaryCached) cacheResponse
        else {
            summaryMutableLiveData.value = networkResponse
            flowOf(networkResponse)
        }
    }

    private suspend fun saveSummary(summary: SummaryResponse) = summariesDao.saveSummary(summary)

    private suspend fun isSummaryCached(start: String) = summariesDao.isSummaryCached(start) > 0

    private suspend fun getAccessToken() = accessTokenDao.getAccessToken().take(1).toList()[0]

}
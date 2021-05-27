package com.vickikbt.devtyme.repository

import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.utils.SafeApiRequest
import javax.inject.Inject

class SummaryRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val summariesDao = appDatabase.summaryDao()

    init {

    }

    suspend fun fetchSummary() {

    }

    //suspend fun is

}
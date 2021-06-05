package com.vickikbt.devtyme.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.network.ApiService
import com.vickikbt.devtyme.models.Leader
import com.vickikbt.devtyme.utils.ApiException
import com.vickikbt.devtyme.utils.Constants.STARTING_PAGE_INDEX
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BoardPagingSource @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) :
    PagingSource<Int, Leader>() {

    private val accessTokenDao = appDatabase.accessTokenDao()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Leader> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val accessToken = getAccessToken().accessToken

            val networkResponse = apiService.fetchLeaderBoard(token = accessToken, page = page)

            LoadResult.Page(
                data = networkResponse.leaders,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (networkResponse.leaders.isEmpty()) null else page + 1
            )

        } catch (e: ApiException) {
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Leader>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private suspend fun getAccessToken() = accessTokenDao.getAccessToken().take(1).toList()[0]

}
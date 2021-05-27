package com.vickikbt.devtyme.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.devtyme.models.SummaryResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface SummaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSummary(summary: SummaryResponse)

    @Query("SELECT * FROM `Summary Table` WHERE Start=:start")
    fun getSummary(start: String): Flow<SummaryResponse>

    @Query("DELETE FROM `Summary Table`")
    suspend fun deleteAllSummaries()

    @Query("SELECT COUNT(*) FROM `Summary Table` WHERE Start=:start")
    suspend fun isSummaryCached(start: String): Int

}
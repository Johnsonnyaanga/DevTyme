package com.vickikbt.devtyme.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.devtyme.models.AccessToken
import kotlinx.coroutines.flow.Flow

@Dao
interface AccessTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAccessToken(accessToken: AccessToken)

    @Query("SELECT * FROM `AccessToken Table`")
    fun getAccessToken(): Flow<AccessToken>

    @Query("DELETE FROM `AccessToken Table`")
    suspend fun deleteAccessToken()

    @Query("SELECT COUNT(*) FROM `AccessToken Table`")
    suspend fun isUserLoggedIn():Int


}
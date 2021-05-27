package com.vickikbt.devtyme.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.devtyme.models.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserData)

    @Query("SELECT * FROM `User Table`")
    fun getUser(): Flow<UserData>

    @Query("DELETE FROM `User Table`")
    suspend fun deleteUser()

}
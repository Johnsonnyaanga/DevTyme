package com.vickikbt.devtyme.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vickikbt.devtyme.data.cache.daos.AccessTokenDao
import com.vickikbt.devtyme.models.AccessToken
import com.vickikbt.devtyme.utils.Constants.DATABASE_VERSION

@Database(entities = [AccessToken::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accessTokenDao(): AccessTokenDao

}
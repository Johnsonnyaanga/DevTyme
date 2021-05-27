package com.vickikbt.devtyme.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vickikbt.devtyme.data.cache.converters.SummaryListConverter
import com.vickikbt.devtyme.data.cache.daos.AccessTokenDao
import com.vickikbt.devtyme.data.cache.daos.SummaryDao
import com.vickikbt.devtyme.data.cache.daos.UserDao
import com.vickikbt.devtyme.models.AccessToken
import com.vickikbt.devtyme.models.SummaryResponse
import com.vickikbt.devtyme.models.User
import com.vickikbt.devtyme.utils.Constants.DATABASE_VERSION

@Database(
    entities = [AccessToken::class, User::class, SummaryResponse::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(SummaryListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accessTokenDao(): AccessTokenDao

    abstract fun userDao(): UserDao

    abstract fun summaryDao(): SummaryDao

}
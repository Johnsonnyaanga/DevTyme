package com.vickikbt.devtyme.cache

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.cache.daos.AccessTokenDao
import com.vickikbt.domain.models.AccessToken
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AccessDaoTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var accessTokenDao: AccessTokenDao

    private val accessToken =
        AccessToken("accessToken", 5.0, "refreshToken", "scopes", "tokenType", "uid", 1F)

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        accessTokenDao = appDatabase.accessTokenDao()
    }

    @After
    fun tearDown() = appDatabase.close()

    @Test
    fun saveAccessTokenTest() = runBlocking {
        accessTokenDao.saveAccessToken(accessToken)

        val result = accessTokenDao.getAccessToken().take(1).toList()[0]

        assertThat(result).isEqualTo(accessToken)
    }

    @Test
    fun getAccessTokenTest() = runBlocking {
        accessTokenDao.saveAccessToken(accessToken)

        val result = accessTokenDao.getAccessToken().take(1).toList()[0]

        assertThat(result).isEqualTo(accessToken)
    }

    @Test
    fun deleteAccessTokenTest() = runBlocking {
        accessTokenDao.saveAccessToken(accessToken)

        accessTokenDao.deleteAccessToken()

        val result = accessTokenDao.getAccessToken().take(1).toList()[0]

        assertThat(result).isNull()
    }

    @Test
    fun isUserLoggedInTest() = runBlocking {
        accessTokenDao.saveAccessToken(accessToken)

        val result = accessTokenDao.isUserLoggedIn()

        assertThat(result).isGreaterThan(0)
    }


}
package com.vickikbt.devtyme.cache

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.vickikbt.devtyme.data.cache.AppDatabase
import com.vickikbt.devtyme.data.cache.daos.UserDao
import com.vickikbt.devtyme.models.UserData
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var userDao: UserDao

    private val user = UserData(
        "bio",
        "colorScheme",
        "createdAt",
        "dateFormat",
        "defaultDashboardRange",
        "displayName",
        "durationSliceBy",
        "email",
        "fullName",
        true,
        "humanReadableWebsite",
        "id",
        true,
        true,
        false,
        true,
        true,
        "lastHeartBeat",
        "lastPlugin",
        "lastPluginName",
        "lastProject",
        "location",
        true,
        null,
        true,
        "photo",
        true,
        "plan",
        "publicEmail",
        "publicProfile",
        false,
        1,
        "timeZone",
        "username",
        "website",
        1,
        false

    )

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = appDatabase.userDao()
    }

    @After
    fun tearDown() = appDatabase.close()

    @Test
    fun saveUserTest() = runBlocking {
        userDao.saveUser(user)

        val result = userDao.getUser().take(1).toList()[0]

        assertThat(result).isEqualTo(user)
    }

    @Test
    fun getUserTest() = runBlocking {
        userDao.saveUser(user)

        val result = userDao.getUser().take(1).toList()[0]

        assertThat(result).isEqualTo(user)
    }

    @Test
    fun deleteUserTest() = runBlocking {
        userDao.saveUser(user)
        userDao.deleteUser()

        val result = userDao.getUser().take(1).toList()[0]

        assertThat(result).isNull()
    }

}
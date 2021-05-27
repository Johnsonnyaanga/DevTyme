package com.vickikbt.devtyme.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ExtensionFunctionsTest {

    private val username = "Victor Kabata Ndung'u"

    @Test
    fun getDisplayNameTest() {
        val result = username.getDisplayName()
        assertThat(result).isEqualTo("Victor")
    }

}
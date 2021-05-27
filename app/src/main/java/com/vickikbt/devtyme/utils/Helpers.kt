package com.vickikbt.devtyme.utils

import java.util.*

object Helpers {

    fun getTimeOfDay(): String {
        val calendar = Calendar.getInstance()
        val timeOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when (timeOfDay) {
            in 0..11 -> "Good Morning,"
            in 12..15 -> "Good Afternoon,"
            in 16..20 -> "Good Evening,"
            else -> "Hey,"
        }
    }

}
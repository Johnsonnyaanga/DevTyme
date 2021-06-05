package com.vickikbt.devtyme.utils

import java.text.SimpleDateFormat
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

    fun getCurrentDateTime(): String {
        val today = Calendar.getInstance()

        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(today.time)
    }

    fun getDaysOfWeek(): Array<String?> {
        val dateFormat = SimpleDateFormat("EEEEE\ndd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

        val days = arrayOfNulls<String>(7)
        for (i in 0..6) {
            days[i] = dateFormat.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return days
    }

    fun getDaysOfWeekRange(): Array<String?> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

        val days = arrayOfNulls<String>(7)
        for (i in 0..6) {
            days[i] = dateFormat.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return days
    }

}
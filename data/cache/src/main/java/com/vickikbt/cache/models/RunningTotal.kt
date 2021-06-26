package com.vickikbt.cache.models


data class RunningTotal(
    val dailyAverage: Int,

    val humanReadableDailyAverage: String,

    val humanReadableTotal: String,

    val languages: List<UserLanguage>,

    val modifiedAt: String,

    val totalSeconds: Double
)
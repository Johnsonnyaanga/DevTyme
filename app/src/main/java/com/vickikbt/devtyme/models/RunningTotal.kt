package com.vickikbt.devtyme.models

import com.google.gson.annotations.SerializedName

data class RunningTotal(
    @SerializedName("daily_average")
    val daily_average: Int?=null,
    @SerializedName("human_readable_daily_average")
    val humanReadableDailyAverage: String?=null,
    @SerializedName("human_readable_total")
    val humanReadableTotal: String?=null,
    @SerializedName("languages")
    val languages: List<Language>?=null,
    @SerializedName("total_seconds")
    val totalSeconds: Double?=null
)
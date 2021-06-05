package com.vickikbt.devtyme.models

import com.google.gson.annotations.SerializedName

data class RunningTotal(
    @SerializedName("daily_average")
    val dailyAverage: Int,

    @SerializedName("human_readable_daily_average")
    val humanReadableDailyAverage: String,

    @SerializedName("human_readable_total")
    val humanReadableTotal: String,

    @SerializedName("languages")
    val languages: List<UserLanguage>,

    @SerializedName("modified_at")
    val modifiedAt: String,

    @SerializedName("total_seconds")
    val totalSeconds: Double
)
package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class RunningTotalDto(
    @SerializedName("daily_average")
    val dailyAverage: Int,

    @SerializedName("human_readable_daily_average")
    val humanReadableDailyAverage: String,

    @SerializedName("human_readable_total")
    val humanReadableTotal: String,

    @SerializedName("languages")
    val languages: List<UserLanguageDto>,

    @SerializedName("modified_at")
    val modifiedAt: String,

    @SerializedName("total_seconds")
    val totalSeconds: Double
)
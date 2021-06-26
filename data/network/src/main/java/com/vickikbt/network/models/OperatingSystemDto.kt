package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class OperatingSystemDto(
    @SerializedName("digital")
    val digital: String?,

    @SerializedName("hours")
    val hours: Int?,

    @SerializedName("minutes")
    val minutes: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("percent")
    val percent: Double?,

    @SerializedName("seconds")
    val seconds: Int?,

    @SerializedName("text")
    val text: String?,

    @SerializedName("total_seconds")
    val totalSeconds: Double?
)
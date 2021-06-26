package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class GrandTotalDto(
    @SerializedName("digital")
    val digital: String?=null,

    @SerializedName("hours")
    val hours: Int?=null,

    @SerializedName("minutes")
    val minutes: Int?=null,

    @SerializedName("text")
    val text: String?=null,
    
    @SerializedName("total_seconds")
    val totalSeconds: Double?=null
)
package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class ProjectDto(
    @SerializedName("digital")
    val digital: String?=null,

    @SerializedName("hours")
    val hours: Int?=null,

    @SerializedName("minutes")
    val minutes: Int?=null,

    @SerializedName("name")
    val name: String?=null,

    @SerializedName("percent")
    val percent: Double?=null,

    @SerializedName("seconds")
    val seconds: Int?=null,

    @SerializedName("text")
    val text: String?=null,
    
    @SerializedName("total_seconds")
    val totalSeconds: Double?=null
)
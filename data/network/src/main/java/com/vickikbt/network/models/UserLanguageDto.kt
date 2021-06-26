package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class UserLanguageDto(

    @SerializedName("name")
    val name: String,

    @SerializedName("total_seconds")
    val totalSeconds: Double
)
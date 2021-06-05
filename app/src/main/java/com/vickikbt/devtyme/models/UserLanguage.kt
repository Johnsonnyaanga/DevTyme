package com.vickikbt.devtyme.models


import com.google.gson.annotations.SerializedName

data class UserLanguage(

    @SerializedName("name")
    val name: String,

    @SerializedName("total_seconds")
    val totalSeconds: Double
)
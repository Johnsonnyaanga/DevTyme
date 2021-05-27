package com.vickikbt.devtyme.models


import com.google.gson.annotations.SerializedName

data class Range(
    val date: String?,
    val end: String?,
    val start: String?,
    val text: String?,
    val timezone: String?
)
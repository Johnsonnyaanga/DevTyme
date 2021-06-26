package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class SummaryResponseDto(

    @SerializedName("data")
    val summary: List<SummaryDto>,

    @SerializedName("end")
    val end: String? = null,

    @SerializedName("start")
    val start: String
)
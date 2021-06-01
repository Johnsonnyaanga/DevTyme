package com.vickikbt.devtyme.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("rank")
    val rank: Int?=null,
    @SerializedName("running_total")
    val runningTotal: RunningTotal?=null,
    @SerializedName("user")
    val user: User?=null,
)
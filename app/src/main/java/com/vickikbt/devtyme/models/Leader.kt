package com.vickikbt.devtyme.models


import com.google.gson.annotations.SerializedName

data class Leader(
    @SerializedName("rank")
    val rank: Int,

    @SerializedName("running_total")
    val runningTotal: RunningTotal,

    @SerializedName("user")
    val user: User
)
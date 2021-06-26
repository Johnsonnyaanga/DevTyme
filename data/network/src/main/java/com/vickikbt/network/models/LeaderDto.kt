package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class LeaderDto(
    @SerializedName("rank")
    val rank: Int,

    @SerializedName("running_total")
    val runningTotal: RunningTotalDto,

    @SerializedName("user")
    val user: UserDto
)
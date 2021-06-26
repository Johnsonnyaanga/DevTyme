package com.vickikbt.cache.models


data class Leader(
    val rank: Int,

    val runningTotal: RunningTotal,

    val user: User
)
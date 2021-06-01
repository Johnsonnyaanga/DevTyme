package com.vickikbt.devtyme.models

data class RunningTotal(
    val daily_average: Int,
    val human_readable_daily_average: String,
    val human_readable_total: String,
    val languages: List<Language>,
    val total_seconds: Double
)
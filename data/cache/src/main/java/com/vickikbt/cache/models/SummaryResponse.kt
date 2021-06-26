package com.vickikbt.cache.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Summary Table")
data class SummaryResponse(

    @ColumnInfo(name = "Summary")
    val summary: List<Summary>,

    @ColumnInfo(name = "End")
    val end: String? = null,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Start")
    val start: String
)
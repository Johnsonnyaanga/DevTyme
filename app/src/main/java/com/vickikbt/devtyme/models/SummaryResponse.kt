package com.vickikbt.devtyme.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Summary Table")
data class SummaryResponse(

    @ColumnInfo(name = "Summary")
    @SerializedName("data")
    val summary: List<Summary>,

    @ColumnInfo(name = "End")
    @SerializedName("end")
    val end: String? = null,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Start")
    @SerializedName("start")
    val start: String
)
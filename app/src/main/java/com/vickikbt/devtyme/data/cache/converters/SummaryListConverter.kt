package com.vickikbt.devtyme.data.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vickikbt.devtyme.models.Summary

class SummaryListConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(summaries: List<Summary>): String? {
        if (summaries.isNullOrEmpty()) return null

        val type = object : TypeToken<List<Summary>?>() {}.type
        return gson.toJson(summaries, type)
    }

    @TypeConverter
    fun to(summaryEntityString: String?): List<Summary>? {
        if (summaryEntityString.isNullOrEmpty()) return null

        val type = object : TypeToken<List<Summary>?>() {}.type
        return gson.fromJson(summaryEntityString, type)
    }

}
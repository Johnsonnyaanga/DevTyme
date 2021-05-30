package com.vickikbt.devtyme.utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.getDisplayName(): String {
    return this.substringBefore(" ").trim()
}

fun String.toPresentation(): String? {
    val dateFormat = SimpleDateFormat("EEEEE\ndd", Locale.getDefault())
    return dateFormat.format(this)
}

fun String.toUTC(): String? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return dateFormat.format(this)
}



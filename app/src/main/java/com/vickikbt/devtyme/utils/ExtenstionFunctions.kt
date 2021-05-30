package com.vickikbt.devtyme.utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.getDisplayName(): String {
    return this.substringBefore(" ").trim()
}

fun String.toUTC() {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    dateFormat.format(this)
}



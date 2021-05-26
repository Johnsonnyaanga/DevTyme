package com.vickikbt.devtyme.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import timber.log.Timber

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}




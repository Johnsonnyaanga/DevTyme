package com.vickikbt.devtyme.models

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("data")
    val userData: UserData? = null
)
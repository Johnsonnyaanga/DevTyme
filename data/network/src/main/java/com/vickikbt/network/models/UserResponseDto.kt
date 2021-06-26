package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName


data class UserResponseDto(
    @SerializedName("data")
    val user: UserDto
)
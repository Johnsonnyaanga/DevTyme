package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class LeadersResponseDto(
    @SerializedName("current_user")
    val currentUser: LeaderDto,

    @SerializedName("data")
    val leaders: List<LeaderDto>,

    @SerializedName("language")
    val language: UserLanguageDto,

    @SerializedName("modified_at")
    val modifiedAt: String,

    @SerializedName("page")
    val page: Int,

    @SerializedName("timeout")
    val timeout: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("writes_only")
    val writesOnly: Boolean
)
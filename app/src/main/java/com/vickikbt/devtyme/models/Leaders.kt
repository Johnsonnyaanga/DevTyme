package com.vickikbt.devtyme.models


import com.google.gson.annotations.SerializedName

data class Leaders(
    @SerializedName("current_user")
    val currentUser: CurrentUser,

    @SerializedName("data")
    val leaders: List<LeaderResponse>,

    @SerializedName("language")
    val language: UserLanguage,

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
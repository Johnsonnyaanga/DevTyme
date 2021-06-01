package com.vickikbt.devtyme.models

import com.google.gson.annotations.SerializedName

data class Leaders(
    @SerializedName("current_user")
    val currentUser: User,
    @SerializedName("data")
    val board: List<Data>?=null,
    @SerializedName("language")
    val language: Language,
    @SerializedName("modified_at")
    val modifiedAt: String?=null,
    @SerializedName("page")
    val page: Int?=null,
    @SerializedName("range")
    val range: Range?=null,
    @SerializedName("timeout")
    val timeout: Int?=null,
    @SerializedName("total_pages")
    val totalPages: Int?=null,
    @SerializedName("writes_only")
    val writesOnly: Boolean?=null,
)
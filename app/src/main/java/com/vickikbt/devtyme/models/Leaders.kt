package com.vickikbt.devtyme.models

data class Leaders(
    val current_user: Any,
    val `data`: List<Data>,
    val language: Any,
    val modified_at: String,
    val page: Int,
    val range: Range,
    val timeout: Int,
    val total_pages: Int,
    val writes_only: Boolean
)
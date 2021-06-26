package com.vickikbt.cache.models


data class LeadersResponse(
    val currentUser: Leader,

    val leaders: List<Leader>,

    val language: UserLanguage,

    val modifiedAt: String,

    val page: Int,

    val timeout: Int,

    val totalPages: Int,

    val writesOnly: Boolean
)
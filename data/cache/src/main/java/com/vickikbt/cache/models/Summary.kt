package com.vickikbt.cache.models


data class Summary(
    val categories: List<Category>? = null,

    val editors: List<Editor>? = null,

    val grandTotal: GrandTotal? = null,

    val languages: List<Language>? = null,

    val machines: List<Machine>? = null,

    val operatingSystems: List<OperatingSystem>? = null,

    val projects: List<Project>? = null,

    val range: Range? = null
)
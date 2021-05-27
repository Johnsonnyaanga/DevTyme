package com.vickikbt.devtyme.models


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("categories")
    val categories: List<Category>? = null,

    @SerializedName("editors")
    val editors: List<Editor>? = null,

    @SerializedName("grand_total")
    val grandTotal: GrandTotal? = null,

    @SerializedName("languages")
    val languages: List<Language>? = null,

    @SerializedName("machines")
    val machines: List<Machine>? = null,

    @SerializedName("operating_systems")
    val operatingSystems: List<OperatingSystem>? = null,

    @SerializedName("projects")
    val projects: List<Project>? = null,

    @SerializedName("range")
    val range: Range? = null
)
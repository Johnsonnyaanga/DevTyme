package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class SummaryDto(
    @SerializedName("categories")
    val categories: List<CategoryDto>? = null,

    @SerializedName("editors")
    val editors: List<EditorDto>? = null,

    @SerializedName("grand_total")
    val grandTotal: GrandTotalDto? = null,

    @SerializedName("languages")
    val languages: List<LanguageDto>? = null,

    @SerializedName("machines")
    val machines: List<MachineDto>? = null,

    @SerializedName("operating_systems")
    val operatingSystems: List<OperatingSystemDto>? = null,

    @SerializedName("projects")
    val projects: List<ProjectDto>? = null,

    @SerializedName("range")
    val range: RangeDto? = null
)
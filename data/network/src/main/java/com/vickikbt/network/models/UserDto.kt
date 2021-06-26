package com.vickikbt.network.models


import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("bio")
    val bio: String? = null,

    @SerializedName("color_scheme")
    val colorScheme: String? = null,

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("date_format")
    val dateFormat: String? = null,

    @SerializedName("default_dashboard_range")
    val defaultDashboardRange: String? = null,

    @SerializedName("display_name")
    val displayName: String? = null,

    @SerializedName("durations_slice_by")
    val durationsSliceBy: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("has_premium_features")
    val hasPremiumFeatures: Boolean? = null,

    @SerializedName("human_readable_website")
    val humanReadableWebsite: String? = null,

    @SerializedName("id")
    val id: String,

    @SerializedName("is_email_confirmed")
    val isEmailConfirmed: Boolean? = null,

    @SerializedName("is_email_public")
    val isEmailPublic: Boolean? = null,

    @SerializedName("is_hireable")
    val isHireable: Boolean? = null,

    @SerializedName("is_onboarding_finished")
    val isOnboardingFinished: Boolean? = null,

    @SerializedName("languages_used_public")
    val languagesUsedPublic: Boolean? = null,

    @SerializedName("last_heartbeat_at")
    val lastHeartbeatAt: String? = null,

    @SerializedName("last_plugin")
    val lastPlugin: String? = null,

    @SerializedName("last_plugin_name")
    val lastPluginName: String? = null,

    @SerializedName("last_project")
    val lastProject: String? = null,

    @SerializedName("location")
    val location: String? = null,

    @SerializedName("logged_time_public")
    val loggedTimePublic: Boolean? = null,

    @SerializedName("modified_at")
    val modifiedAt: String? = null,

    @SerializedName("needs_payment_method")
    val needsPaymentMethod: Boolean? = null,

    @SerializedName("photo")
    val photo: String? = null,

    @SerializedName("photo_public")
    val photoPublic: Boolean? = null,

    @SerializedName("plan")
    val plan: String? = null,

    @SerializedName("public_email")
    val publicEmail: String? = null,

    @SerializedName("public_profile_time_range")
    val publicProfileTimeRange: String? = null,

    @SerializedName("show_machine_name_ip")
    val showMachineNameIp: Boolean? = null,

    @SerializedName("timeout")
    val timeout: Int? = null,

    @SerializedName("timezone")
    val timezone: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("website")
    val website: String? = null,

    @SerializedName("weekday_start")
    val weekdayStart: Int? = null,

    @SerializedName("writes_only")
    val writesOnly: Boolean? = null
)
package com.vickikbt.devtyme.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User Table")
data class UserData(
    @ColumnInfo(name = "Bio")
    @SerializedName("bio")
    val bio: String? = null,

    @ColumnInfo(name = "Color Scheme")
    @SerializedName("color_scheme")
    val colorScheme: String? = null,

    @ColumnInfo(name = "Created At")
    @SerializedName("created_at")
    val createdAt: String? = null,

    @ColumnInfo(name = "Data Format")
    @SerializedName("date_format")
    val dateFormat: String? = null,

    @ColumnInfo(name = "Default Dashboard Range")
    @SerializedName("default_dashboard_range")
    val defaultDashboardRange: String? = null,

    @ColumnInfo(name = "Display Name")
    @SerializedName("display_name")
    val displayName: String? = null,

    @ColumnInfo(name = "Duration Slice By")
    @SerializedName("durations_slice_by")
    val durationsSliceBy: String? = null,

    @ColumnInfo(name = "Email")
    @SerializedName("email")
    val email: String? = null,

    @ColumnInfo(name = "Full Name")
    @SerializedName("full_name")
    val fullName: String? = null,

    @ColumnInfo(name = "Has Premium Features")
    @SerializedName("has_premium_features")
    val hasPremiumFeatures: Boolean? = null,

    @ColumnInfo(name = "Human Readable Website")
    @SerializedName("human_readable_website")
    val humanReadableWebsite: String? = null,

    @ColumnInfo(name = "ID")
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: String,

    @ColumnInfo(name = "Is Email Confirmed")
    @SerializedName("is_email_confirmed")
    val isEmailConfirmed: Boolean? = null,

    @ColumnInfo(name = "Is Email Public")
    @SerializedName("is_email_public")
    val isEmailPublic: Boolean? = null,

    @ColumnInfo(name = "Is Hireable")
    @SerializedName("is_hireable")
    val isHireable: Boolean? = null,

    @ColumnInfo(name = "Is Onboarding Finished")
    @SerializedName("is_onboarding_finished")
    val isOnboardingFinished: Boolean? = null,

    @ColumnInfo(name = "Languages Used Public")
    @SerializedName("languages_used_public")
    val languagesUsedPublic: Boolean? = null,

    @ColumnInfo(name = "Last Heartbeat At")
    @SerializedName("last_heartbeat_at")
    val lastHeartbeatAt: String? = null,

    @ColumnInfo(name = "Last Plugin")
    @SerializedName("last_plugin")
    val lastPlugin: String? = null,

    @ColumnInfo(name = "Last Plugin Name")
    @SerializedName("last_plugin_name")
    val lastPluginName: String? = null,

    @ColumnInfo(name = "Last Project")
    @SerializedName("last_project")
    val lastProject: String? = null,

    @ColumnInfo(name = "Location")
    @SerializedName("location")
    val location: String? = null,

    @ColumnInfo(name = "Logged Time Public")
    @SerializedName("logged_time_public")
    val loggedTimePublic: Boolean? = null,

    @ColumnInfo(name = "Modified At")
    @SerializedName("modified_at")
    val modifiedAt: String? = null,

    @ColumnInfo(name = "Needs Payment Method")
    @SerializedName("needs_payment_method")
    val needsPaymentMethod: Boolean? = null,

    @ColumnInfo(name = "Photo")
    @SerializedName("photo")
    val photo: String? = null,

    @ColumnInfo(name = "Photo Public")
    @SerializedName("photo_public")
    val photoPublic: Boolean? = null,

    @ColumnInfo(name = "Plan")
    @SerializedName("plan")
    val plan: String? = null,

    @ColumnInfo(name = "Public Email")
    @SerializedName("public_email")
    val publicEmail: String? = null,

    @ColumnInfo(name = "Public Profile Time Range")
    @SerializedName("public_profile_time_range")
    val publicProfileTimeRange: String? = null,

    @ColumnInfo(name = "Show Machine Name IP")
    @SerializedName("show_machine_name_ip")
    val showMachineNameIp: Boolean? = null,

    @ColumnInfo(name = "Timeout")
    @SerializedName("timeout")
    val timeout: Int? = null,

    @ColumnInfo(name = "Timezone")
    @SerializedName("timezone")
    val timezone: String? = null,

    @ColumnInfo(name = "Username")
    @SerializedName("username")
    val username: String? = null,

    @ColumnInfo(name = "Website")
    @SerializedName("website")
    val website: String? = null,

    @ColumnInfo(name = "Weekday Start")
    @SerializedName("weekday_start")
    val weekdayStart: Int? = null,

    @ColumnInfo(name = "Write Only")
    @SerializedName("writes_only")
    val writesOnly: Boolean? = null
)
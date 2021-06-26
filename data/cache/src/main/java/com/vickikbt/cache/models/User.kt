package com.vickikbt.cache.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User Table")
data class User(
    @ColumnInfo(name = "Bio")
    val bio: String? = null,

    @ColumnInfo(name = "Color Scheme")
    val colorScheme: String? = null,

    @ColumnInfo(name = "Created At")
    val createdAt: String? = null,

    @ColumnInfo(name = "Data Format")
    val dateFormat: String? = null,

    @ColumnInfo(name = "Default Dashboard Range")
    val defaultDashboardRange: String? = null,

    @ColumnInfo(name = "Display Name")
    val displayName: String? = null,

    @ColumnInfo(name = "Duration Slice By")
    val durationsSliceBy: String? = null,

    @ColumnInfo(name = "Email")
    val email: String? = null,

    @ColumnInfo(name = "Full Name")
    val fullName: String? = null,

    @ColumnInfo(name = "Has Premium Features")
    val hasPremiumFeatures: Boolean? = null,

    @ColumnInfo(name = "Human Readable Website")
    val humanReadableWebsite: String? = null,

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = false)
    val id: String,

    @ColumnInfo(name = "Is Email Confirmed")
    val isEmailConfirmed: Boolean? = null,

    @ColumnInfo(name = "Is Email Public")
    val isEmailPublic: Boolean? = null,

    @ColumnInfo(name = "Is Hireable")
    val isHireable: Boolean? = null,

    @ColumnInfo(name = "Is Onboarding Finished")
    val isOnboardingFinished: Boolean? = null,

    @ColumnInfo(name = "Languages Used Public")
    val languagesUsedPublic: Boolean? = null,

    @ColumnInfo(name = "Last Heartbeat At")
    val lastHeartbeatAt: String? = null,

    @ColumnInfo(name = "Last Plugin")
    val lastPlugin: String? = null,

    @ColumnInfo(name = "Last Plugin Name")
    val lastPluginName: String? = null,

    @ColumnInfo(name = "Last Project")
    val lastProject: String? = null,

    @ColumnInfo(name = "Location")
    val location: String? = null,

    @ColumnInfo(name = "Logged Time Public")
    val loggedTimePublic: Boolean? = null,

    @ColumnInfo(name = "Modified At")
    val modifiedAt: String? = null,

    @ColumnInfo(name = "Needs Payment Method")
    val needsPaymentMethod: Boolean? = null,

    @ColumnInfo(name = "Photo")
    val photo: String? = null,

    @ColumnInfo(name = "Photo Public")
    val photoPublic: Boolean? = null,

    @ColumnInfo(name = "Plan")
    val plan: String? = null,

    @ColumnInfo(name = "Public Email")
    val publicEmail: String? = null,

    @ColumnInfo(name = "Public Profile Time Range")
    val publicProfileTimeRange: String? = null,

    @ColumnInfo(name = "Show Machine Name IP")
    val showMachineNameIp: Boolean? = null,

    @ColumnInfo(name = "Timeout")
    val timeout: Int? = null,

    @ColumnInfo(name = "Timezone")
    val timezone: String? = null,

    @ColumnInfo(name = "Username")
    val username: String? = null,

    @ColumnInfo(name = "Website")
    val website: String? = null,

    @ColumnInfo(name = "Weekday Start")
    val weekdayStart: Int? = null,

    @ColumnInfo(name = "Write Only")
    val writesOnly: Boolean? = null
)
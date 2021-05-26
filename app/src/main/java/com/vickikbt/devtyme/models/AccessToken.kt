package com.vickikbt.devtyme.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "AccessToken Table")
data class AccessToken(
    @SerializedName("access_token")
    @ColumnInfo(name = "Access Token")
    var accessToken: String,

    @SerializedName("expires_in")
    @ColumnInfo(name = "Expires In")
    var expiresIn: Double,

    @SerializedName("refresh_token")
    @ColumnInfo(name = "Refresh Token")
    var refreshToken: String,

    @SerializedName("scope")
    @ColumnInfo(name = "Scope")
    var scope: String,

    @SerializedName("token_type")
    @ColumnInfo(name = "Token Type")
    var tokenType: String,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("uid")
    @ColumnInfo(name = "UID")
    var uid: String,

    @SerializedName("created_at")
    @ColumnInfo(name = "Created At")
    var createdAt: Float
) {

    //Check for expiry condition
    fun isValid(currentTimeSec: Float) = createdAt + expiresIn > currentTimeSec

}

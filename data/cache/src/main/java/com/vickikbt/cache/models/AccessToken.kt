package com.vickikbt.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AccessToken Table")
data class AccessToken(
    @ColumnInfo(name = "Access Token")
    var accessToken: String,

    @ColumnInfo(name = "Expires In")
    var expiresIn: Double,

    @ColumnInfo(name = "Refresh Token")
    var refreshToken: String,

    @ColumnInfo(name = "Scope")
    var scope: String,

    @ColumnInfo(name = "Token Type")
    var tokenType: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "UID")
    var uid: String,

    @ColumnInfo(name = "Created At")
    var createdAt: Float
) {

    //Check for expiry condition
    fun isValid(currentTimeSec: Float) = createdAt + expiresIn > currentTimeSec

}

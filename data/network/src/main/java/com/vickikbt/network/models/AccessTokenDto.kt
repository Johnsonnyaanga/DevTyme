package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName

data class AccessTokenDto(
    @SerializedName("access_token")
    var accessToken: String,

    @SerializedName("expires_in")
    var expiresIn: Double,

    @SerializedName("refresh_token")
    var refreshToken: String,

    @SerializedName("scope")
    var scope: String,

    @SerializedName("token_type")
    var tokenType: String,

    @SerializedName("uid")
    var uid: String,

    @SerializedName("created_at")
    var createdAt: Float
) {

    //Check for expiry condition
    fun isValid(currentTimeSec: Float) = createdAt + expiresIn > currentTimeSec

}

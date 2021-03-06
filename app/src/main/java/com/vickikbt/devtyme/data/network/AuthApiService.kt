package com.vickikbt.devtyme.data.network

import com.vickikbt.devtyme.models.AccessToken
import com.vickikbt.devtyme.utils.Constants.CLIENT_ID
import com.vickikbt.devtyme.utils.Constants.CLIENT_SECRET
import com.vickikbt.devtyme.utils.Constants.REDIRECT_URL
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun fetchNewAccessToken(
        @Field("client_id") clientId: String = CLIENT_ID,
        @Field("client_secret") clientSecret: String = CLIENT_SECRET,
        @Field("redirect_uri") redirectUri: String = REDIRECT_URL,
        @Field("grant_type") grantType: String? = "authorization_code",
        @Field("code") code: String
    ): Response<AccessToken>

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("oauth/revoke")
    suspend fun revokeAccessToken(
        @Field("client_id") clientId: String = CLIENT_ID,
        @Field("client_secret") clientSecret: String = CLIENT_SECRET,
        @Field("token") accessToken: String,
    ): Response<Void>


}
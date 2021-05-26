package com.vickikbt.devtyme.utils

object Constants {

    //const val BASE_URL = "https://wakatime.com/api/v1/" when the user is already authorized
    const val BASE_URL = "https://wakatime.com/"

    //TODO: Move to config file
    const val CLIENT_ID = "A0ijvQjx34y7GoMRqm9hW0VV"
    const val CLIENT_SECRET =
        "sec_NMqdYxpuCS73WSySycD2ciCoWSuamGzqS9ZMvSldud4qciyhe9sMFhNM39jrsDboCoeo6Eb6zDNsRgaI"
    const val REDIRECT_URL = "devtyme://oauth2"
    val SCOPES = listOf(
        "email",
        "read_logged_time",
        "read_stats",
        "read_private_leaderboards"
    )

    const val WEB_URL =
        "https://wakatime.com/oauth/authorize?client_id=$CLIENT_ID&response_type=code&redirect_uri=$REDIRECT_URL&scope=email&scope=read_logged_time&scope=read_stats&scope=read_private_leaderboards"

}
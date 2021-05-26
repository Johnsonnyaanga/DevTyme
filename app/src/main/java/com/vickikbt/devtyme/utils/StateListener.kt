package com.vickikbt.devtyme.utils

interface StateListener {

    fun onLoading()

    fun onSuccess(message: String?=null)

    fun onError(exception: Exception, message: String?=null)

}
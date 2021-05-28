package com.vickikbt.devtyme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

@HiltAndroidApp
class DevTyme : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        JodaTimeAndroid.init(this)
    }

}
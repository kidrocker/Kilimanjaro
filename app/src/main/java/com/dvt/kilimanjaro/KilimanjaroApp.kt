package com.dvt.kilimanjaro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KilimanjaroApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}
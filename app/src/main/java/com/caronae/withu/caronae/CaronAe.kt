package com.caronae.withu.caronae

import android.app.Application
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics
import io.fabric.sdk.android.Fabric;
/**
* Created by Guilherme on 27/01/2018.
*/

class CaronAe: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this)

        Fabric.with(this, Crashlytics())
    }
}
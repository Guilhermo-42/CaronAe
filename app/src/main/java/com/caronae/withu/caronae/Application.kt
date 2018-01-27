package com.caronae.withu.caronae

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics

/**
* Created by Guilherme on 27/01/2018.
*/

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this)
    }
}
package com.caronae.withu.caronae.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
* Created by Guilherme on 27/01/2018.
*/

    const val SIGN_IN_INTENT = 123

    fun Any.goToActivity(context: Context, activity: Activity) {
        val intent = Intent(context, activity::class.java)
        context.startActivity(intent)
    }

    fun Any.navigateToSignInActivity(context: Activity, intent: Intent) {
        context.startActivityForResult(intent, SIGN_IN_INTENT)
    }
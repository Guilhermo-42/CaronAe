package com.caronae.withu.caronae.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment
import java.io.Serializable

/**
* Created by Guilherme on 27/01/2018.
*/

const val SIGN_IN_INTENT = 123

const val DATA_INTENT = "data"


fun Any.loadFragment(context: FragmentActivity, @IdRes view: Int, fragment: Fragment) {
    val transaction: android.support.v4.app.FragmentTransaction = context.supportFragmentManager.beginTransaction()
    transaction.replace(view, fragment)
            .commit()
}

fun Any.loadFragment(context: FragmentActivity, @IdRes view: Int, fragment: PaperOnboardingFragment) {
    val transaction: android.support.v4.app.FragmentTransaction? = context.supportFragmentManager.beginTransaction()
    transaction?.add(view, fragment)
            ?.commit()
}

fun Any.goToActivity(context: Context, activity: Class<*> ) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
}

fun Any.goToActivityNoBackStack(context: Activity, activity: Class<*>) {
    val intent = Intent(context, activity)
    context.startActivity(intent)
    context.finishAffinity()
}


fun Any.navigateToSignInActivity(context: Activity, intent: Intent) {
    context.startActivityForResult(intent, SIGN_IN_INTENT)
}

fun Any.goToActivityWithData(context: Activity, activity: Class<*>, data: Serializable) {
    val intent = Intent(context, activity)
    intent.putExtra(DATA_INTENT, data)
    context.startActivity(intent)
}

fun Any.goToActivityWithData(context: FragmentActivity?, activity: Class<*>, data: Serializable) {
    val intent = Intent(context, activity)
    intent.putExtra(DATA_INTENT, data)
    context?.startActivity(intent)
}
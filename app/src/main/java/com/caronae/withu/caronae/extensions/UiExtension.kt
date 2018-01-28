package com.caronae.withu.caronae.extensions

import android.app.Activity
import android.app.Fragment
import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.FragmentActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment

/**
* Created by Guilherme on 27/01/2018.
*/

fun Any.loadFragment(context: Activity, @IdRes view: Int, fragment: Fragment) {
    val transaction: FragmentTransaction = context.fragmentManager.beginTransaction()
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
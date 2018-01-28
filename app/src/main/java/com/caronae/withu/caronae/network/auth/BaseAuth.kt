package com.caronae.withu.caronae.network.auth

import android.app.Activity
import android.content.Intent
import com.caronae.withu.caronae.extensions.goToActivityNoBackStack
import com.caronae.withu.caronae.extensions.navigateToSignInActivity
import com.caronae.withu.caronae.flow.main.MainActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import java.util.*

/**
* Created by Guilherme on 27/01/2018.
*/

class BaseAuth {

    fun verifyUserLogged(activity: Activity) {
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            //User not logged
            navigateToSignInActivity(activity, getSignInIntent())
        } else {
            //User logged
            goToActivityNoBackStack(activity, MainActivity::class.java)
        }
    }

    private fun getSignInIntent(): Intent {
        val authUi: AuthUI = AuthUI.getInstance()
        return authUi.createSignInIntentBuilder().setAvailableProviders(
                Arrays.asList(
                        AuthUI.IdpConfig.EmailBuilder().build()
                )
        ).build()
    }

}
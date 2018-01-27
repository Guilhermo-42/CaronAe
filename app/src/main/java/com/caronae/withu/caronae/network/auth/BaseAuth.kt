package com.caronae.withu.caronae.network.auth

import android.app.Activity
import android.content.Intent
import com.caronae.withu.caronae.extensions.goToActivity
import com.caronae.withu.caronae.extensions.navigateToSignInActivity
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
            //Todo User logged
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
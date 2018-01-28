package com.caronae.withu.caronae.flow.splash

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.extensions.SIGN_IN_INTENT
import com.caronae.withu.caronae.extensions.goToActivityNoBackStack
import com.caronae.withu.caronae.flow.onboard.OnboardActivity
import com.caronae.withu.caronae.network.auth.BaseAuth
import com.daimajia.androidanimations.library.Techniques
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import com.viksaa.sssplash.lib.cnst.Flags
import com.viksaa.sssplash.lib.model.ConfigSplash

class SplashActivity : AwesomeSplash() {

    override fun initSplash(configSplash: ConfigSplash?) {

        //Circular reveal
        configSplash?.backgroundColor = R.color.primaryColor
        configSplash?.animCircularRevealDuration = 2000
        configSplash?.revealFlagX = Flags.REVEAL_RIGHT
        configSplash?.revealFlagY = Flags.REVEAL_BOTTOM

        //Logo
        configSplash?.logoSplash = R.mipmap.ic_launcher
        configSplash?.animLogoSplashDuration = 1000
        configSplash?.animLogoSplashTechnique = Techniques.BounceIn

        //Title
        configSplash?.titleSplash = getString(R.string.app_name)
        configSplash?.titleTextColor = R.color.primaryTextColor

    }

    override fun animationsFinished() {
        BaseAuth().verifyUserLogged(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGN_IN_INTENT) {
            val response = IdpResponse.fromResultIntent(data)

            //Login success
            if (resultCode == Activity.RESULT_OK) {
                goToActivityNoBackStack(this, OnboardActivity::class.java)
            } else {
                //Login failed
                if (response == null) {
                    //User pressed back
                    finish()
                }

                when (response?.errorCode) {
                    ErrorCodes.NO_NETWORK -> {
                        AlertDialog.Builder(this)
                                .setMessage(R.string.sign_in_no_connection_message)
                                .setCancelable(false)
                                .setPositiveButton(
                                        R.string.sign_in_no_connection_positive,
                                        { _, _ -> BaseAuth().verifyUserLogged(this) })
                                .setNegativeButton(
                                        R.string.sign_in_no_connection_negative,
                                        { _, _ -> finish() }
                                )
                                .create()
                                .show()
                    }
                    ErrorCodes.UNKNOWN_ERROR -> {
                        AlertDialog.Builder(this)
                                .setMessage(R.string.sign_in_unknown_error_message)
                                .setCancelable(false)
                                .setPositiveButton(
                                        R.string.sign_in_no_connection_positive,
                                        { _, _ -> BaseAuth().verifyUserLogged(this) })
                                .setNegativeButton(
                                        R.string.sign_in_no_connection_negative,
                                        { _, _ -> finish() }
                                )
                                .create()
                    }
                }

            }

        }

    }

}

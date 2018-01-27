package com.caronae.withu.caronae.flow.splash

import com.caronae.withu.caronae.R
import com.daimajia.androidanimations.library.Techniques
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
        //TODO verify if user is logged or not, send to onboarding or main
    }

}

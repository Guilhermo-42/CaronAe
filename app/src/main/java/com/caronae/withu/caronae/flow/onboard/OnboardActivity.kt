package com.caronae.withu.caronae.flow.onboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.extensions.loadFragment
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage

class OnboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        setupOnboard()
    }

    private fun setupOnboard() {
        val elements = ArrayList<PaperOnboardingPage>()
        //TODO Change texts and icons
        elements.add(PaperOnboardingPage("Title", "Desc Text",
                R.color.primaryColor, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher))
        elements.add(PaperOnboardingPage("Title", "Desc Text",
                R.color.primaryColor, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher))
        elements.add(PaperOnboardingPage("Title", "Desc Text",
                R.color.primaryColor, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher))

        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(elements)

        loadFragment(this, R.id.onboard_fragment_container, paperOnboardingFragment)

    }
}

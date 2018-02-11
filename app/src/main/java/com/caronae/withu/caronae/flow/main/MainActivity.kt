package com.caronae.withu.caronae.flow.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.extensions.loadFragment
import com.caronae.withu.caronae.flow.rides.RidesFragment
import com.caronae.withu.caronae.models.main.MainState
import com.caronae.withu.caronae.models.main.State
import com.caronae.withu.caronae.network.auth.BaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var model: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        model?.getState()?.observe(this, Observer<MainState> { mainState ->
            mainState?.let { updateUi(it) }
        })

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                model?.onStateChanged(MainState(State.STATE_PROFILE))
            }
            R.id.nav_rides -> {
                model?.onStateChanged(MainState(State.STATE_RIDES))
            }
            R.id.nav_settings -> {
                model?.onStateChanged(MainState(State.STATE_SETTINGS))
            }
            R.id.nav_share -> {
                model?.onStateChanged(MainState(State.STATE_SHARE))
            }
            R.id.nav_help -> {
                model?.onStateChanged(MainState(State.STATE_HELP))
            }
            R.id.nav_about -> {
                model?.onStateChanged(MainState(State.STATE_ABOUT))
            }
            R.id.nav_logout -> {
                model?.onStateChanged(MainState(State.STATE_LOG_OUT))
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun updateUi(mainState: MainState) {
        when(mainState.state) {
            State.STATE_PROFILE -> TODO()
            State.STATE_RIDES -> loadFragment(this, R.id.fragment_container, RidesFragment.newInstance())
            State.STATE_SETTINGS -> TODO()
            State.STATE_SHARE -> TODO()
            State.STATE_HELP -> TODO()
            State.STATE_ABOUT -> TODO()
            State.STATE_LOADING -> TODO()
            State.STATE_LOG_OUT -> BaseAuth().signOut(this)
        }
    }

}

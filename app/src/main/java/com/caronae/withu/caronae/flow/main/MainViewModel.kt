package com.caronae.withu.caronae.flow.main

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.caronae.withu.caronae.base.BaseViewModel
import com.caronae.withu.caronae.models.main.MainState
import com.caronae.withu.caronae.models.main.State

/**
* Created by Guilherme on 27/01/2018.
*/
class MainViewModel(context: Application): BaseViewModel(context) {

    private var state: MainState? = null

    private var stateLive: MutableLiveData<MainState>? = null

    /* Events */

    fun onStateChanged(newState: MainState) {
        state = newState
        saveState()
    }

    /* Data Binding */

    fun getState(): MutableLiveData<MainState>? {
        if (stateLive == null) {
            state = MainState(State.STATE_PROFILE)
            stateLive?.postValue(state)
        }
        loadState()
        return stateLive
    }

    private fun loadState() {
        stateLive = MutableLiveData()
    }

    private fun saveState() {
        stateLive?.postValue(state)
    }

}
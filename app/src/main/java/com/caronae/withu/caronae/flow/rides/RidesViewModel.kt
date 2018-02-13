package com.caronae.withu.caronae.flow.rides

import android.app.Application
import android.arch.lifecycle.*
import com.caronae.withu.caronae.base.BaseViewModel
import com.caronae.withu.caronae.models.database.DatabaseCollections
import com.caronae.withu.caronae.models.database.rides.Ride
import com.caronae.withu.caronae.network.database.getData

/**
* Created by Guilherme on 11/02/2018.
*/

class RidesViewModel(context: Application) : BaseViewModel(context), LifecycleObserver {

    private var rides: MutableList<Ride>? = null

    private val ridesLive: MutableLiveData<MutableList<Ride>> by lazy {
        MutableLiveData<MutableList<Ride>>()
    }

    /* Events */

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun connectAndRequestModel() {
        getData(DatabaseCollections.RIDES)

        saveRides()
    }

    fun onRidesLoaded(ridesList: MutableList<Ride>?) {
        rides = ridesList
        saveRides()
    }

    /* Data binding */

    fun getRides(): LiveData<MutableList<Ride>> {
        return ridesLive
    }

    private fun saveRides() {
        ridesLive.postValue(rides)
    }
}
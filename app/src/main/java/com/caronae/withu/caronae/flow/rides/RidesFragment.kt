package com.caronae.withu.caronae.flow.rides

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.events.RidesDataRetrieveEvent
import com.caronae.withu.caronae.extensions.goToActivityWithData
import com.caronae.withu.caronae.flow.rides.detail.RideDetailActivity
import com.caronae.withu.caronae.models.database.rides.Ride
import kotlinx.android.synthetic.main.fragment_rides.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

class RidesFragment : Fragment() {

    private val model: RidesViewModel by lazy {
        ViewModelProviders.of(this).get(RidesViewModel::class.java)
    }

    companion object {
        fun newInstance(): Fragment {
            return RidesFragment()
        }
    }

    /* Life Cycle */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rides, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRidesList()

        model.getRides().observe(this, Observer<MutableList<Ride>> { rides ->
            rides?.let { updateRidesUi(it) }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        lifecycle.addObserver(model)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    /* Internal functions */

    private fun setupRidesList() {
        ridesList.layoutManager = LinearLayoutManager(activity)
    }

    /* Ui */

    private fun updateRidesUi(rides: MutableList<Ride>) {
        ridesList.adapter = RidesAdapter(rides, { ride ->
            goToActivityWithData(activity, RideDetailActivity::class.java, ride)
        })
        ridesList.adapter.notifyDataSetChanged()
        ridesProgressBar.visibility = View.GONE
    }

    /* Event subscribes */

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: RidesDataRetrieveEvent) {
        val rideList = event.querySnapshot.documents.mapTo(ArrayList()) { it.toObject(Ride::class.java) }
        model.onRidesLoaded(rideList)
    }
}

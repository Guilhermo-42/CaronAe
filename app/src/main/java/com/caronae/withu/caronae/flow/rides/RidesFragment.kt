package com.caronae.withu.caronae.flow.rides

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.events.RidesDataRetrieveEvent
import com.caronae.withu.caronae.models.database.DatabaseCollections
import com.caronae.withu.caronae.models.database.rides.Ride
import com.caronae.withu.caronae.network.database.getData
import kotlinx.android.synthetic.main.fragment_rides.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * A simple [Fragment] subclass.
 */
class RidesFragment : Fragment() {

    private var rideList: MutableList<Ride>? = null

    companion object {
        fun newInstance(): Fragment {
            return RidesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rides, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData(DatabaseCollections.RIDES)

        setupRidesList()
    }

    private fun setupRidesList() {
        ridesList.layoutManager = LinearLayoutManager(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: RidesDataRetrieveEvent) {
        rideList = ArrayList()
        for (document in event.querySnapshot.documents) {
            rideList?.add(document.toObject(Ride::class.java))
        }
        ridesList.adapter = RidesAdapter(rideList)
        ridesList.adapter.notifyDataSetChanged()
    }
}

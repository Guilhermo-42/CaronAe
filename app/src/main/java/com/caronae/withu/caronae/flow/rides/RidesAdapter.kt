package com.caronae.withu.caronae.flow.rides

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caronae.withu.caronae.R
import com.caronae.withu.caronae.models.database.rides.Ride
import kotlinx.android.synthetic.main.rides_list_item.view.*

        /**
         * Created by Guilherme on 10/02/2018.
         */
typealias OnRideItemListClick = (ride: Ride) -> Unit

class RidesAdapter(private val ridesList: MutableList<Ride>?, callback: OnRideItemListClick) : RecyclerView.Adapter<RidesAdapter.RidesAdapterViewHolder>() {

    private var listener = callback

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RidesAdapterViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.rides_list_item, parent, false)

        return RidesAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ridesList?.size!!
    }

    override fun onBindViewHolder(holder: RidesAdapterViewHolder?, position: Int) {
        holder?.rideTitle?.text = ridesList?.get(position)?.name
        holder?.rideDriver?.text = ridesList?.get(position)?.driver?.firstName
        holder?.rideSchedulingTime?.text = ridesList?.get(position)?.time?.departureTime?.preferredTime
        holder?.itemView?.setOnClickListener {
            listener.invoke(ridesList?.get(position)!!)
        }
    }


    class RidesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rideTitle = itemView.ridesItemTitle
        val rideDriver = itemView.ridesItemDriverName
        val rideSchedulingTime = itemView.ridesItemScheduleTime
    }

}
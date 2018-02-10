package com.caronae.withu.caronae.models.database.rides

import com.caronae.withu.caronae.models.database.rides.local.Local
import com.caronae.withu.caronae.models.database.rides.time.Time

/**
* Created by Guilherme on 28/01/2018.
*/
data class Ride(var car: Car, var driver: Driver, var local: Local, var publishDate: String,
                var rideTimes: RideTimes, var time: Time, var description: String, var fee: String,
                var name: String, var availableSeats: Int)
package com.caronae.withu.caronae.models.database.rides

import com.caronae.withu.caronae.models.database.rides.local.Local
import com.caronae.withu.caronae.models.database.rides.time.Time
import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/
class Ride: Serializable{

    var car: Car? = null
    var driver: Driver? = null
    var local: Local? = null
    var publishDate: String? = null
    var rideTimes: RideTimes? = null
    var time: Time? = null
    var description: String? = null
    var fee: String? = null
    var name: String? = null
    var availableSeats: Int? = null

    constructor(car: Car, driver: Driver, local: Local, publishDate: String, rideTimes: RideTimes,
                time: Time, description: String, fee: String, name: String, availableSeats: Int)

    constructor()

}
package com.caronae.withu.caronae.models.database.rides.time

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/

class Time: Serializable {

    var departureTime: DepartureTime? = null
    var arrivalTime: String? = null

    constructor(departureTime: DepartureTime, arrivalTime: String)

    constructor()

}
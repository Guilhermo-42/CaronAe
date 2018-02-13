package com.caronae.withu.caronae.models.database.rides.local

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/

class Local: Serializable{

    var arrivalPlace: ArrivalLocal? = null
    var departureLocal: DepartureLocal? = null
    var description: String? = null

    constructor(arrivalLocal: ArrivalLocal, departureLocal: DepartureLocal, description: String)

    constructor()

}
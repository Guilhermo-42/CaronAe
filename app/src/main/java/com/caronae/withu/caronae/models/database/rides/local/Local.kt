package com.caronae.withu.caronae.models.database.rides.local

/**
* Created by Guilherme on 28/01/2018.
*/

class Local{

    var arrivalPlace: ArrivalLocal? = null
    var departureLocal: DepartureLocal? = null
    var description: String? = null

    constructor(arrivalLocal: ArrivalLocal, departureLocal: DepartureLocal, description: String)

    constructor()

}
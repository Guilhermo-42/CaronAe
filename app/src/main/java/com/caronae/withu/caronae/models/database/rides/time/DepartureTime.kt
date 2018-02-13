package com.caronae.withu.caronae.models.database.rides.time

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/
class DepartureTime: Serializable{

    var preferredTime: String? = null
    var toleranceTime: String? = null

    constructor(preferredTime: String, toleranceTime: String)

    constructor()

}
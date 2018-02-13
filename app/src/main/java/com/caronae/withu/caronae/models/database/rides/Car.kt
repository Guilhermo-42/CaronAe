package com.caronae.withu.caronae.models.database.rides

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/
class Car: Serializable{

    var color: String? = null
    var model: String? = null
    var plate: String? = null
    var seats: Int? = null

    constructor(color: String, model: String, plate: String, seats: Int)

    constructor()

}
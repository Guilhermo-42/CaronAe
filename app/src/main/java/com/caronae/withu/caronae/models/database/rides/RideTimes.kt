package com.caronae.withu.caronae.models.database.rides

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/
class RideTimes: Serializable{

    var days: List<Boolean>? = null

    constructor(days: List<Boolean>)
    
    constructor()
}
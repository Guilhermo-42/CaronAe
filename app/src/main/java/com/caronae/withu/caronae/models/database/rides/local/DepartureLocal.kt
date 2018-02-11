package com.caronae.withu.caronae.models.database.rides.local

/**
* Created by Guilherme on 28/01/2018.
*/
class DepartureLocal{

    var cep: String? = null
    var city: String? = null
    var lat: String? = null
    var long: String? = null
    var neighbourhood: String? = null
    var reference: String? = null
    var state: String? = null
    var street: String? = null

    constructor(cep: String, city: String, lat: String, long: String, neighbourhood: String,
                reference: String, state: String, street: String)

    constructor()

}
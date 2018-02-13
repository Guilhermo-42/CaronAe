package com.caronae.withu.caronae.models.database.rides

import java.io.Serializable

/**
* Created by Guilherme on 28/01/2018.
*/
class Driver: Serializable{
    var gender: String? = null
    var age: Int? = null
    var firstName: String? = null
    var lastName: String? = null
    var phone: String? = null

    constructor(gender: String, age: Int, firstName: String, lastName: String, phone: String)

    constructor()

}
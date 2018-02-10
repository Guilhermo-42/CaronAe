package com.caronae.withu.caronae.models.database

/**
* Created by Guilherme on 28/01/2018.
*/
enum class DatabaseCollections(private val description: String) {

    RIDES("Rides");

    override fun toString(): String {
        return description
    }}
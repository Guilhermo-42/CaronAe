package com.caronae.withu.caronae.mock

import com.caronae.withu.caronae.models.database.DatabaseCollections
import com.caronae.withu.caronae.models.database.rides.Car
import com.caronae.withu.caronae.models.database.rides.Driver
import com.caronae.withu.caronae.models.database.rides.Ride
import com.caronae.withu.caronae.models.database.rides.RideTimes
import com.caronae.withu.caronae.models.database.rides.local.ArrivalLocal
import com.caronae.withu.caronae.models.database.rides.local.DepartureLocal
import com.caronae.withu.caronae.models.database.rides.local.Local
import com.caronae.withu.caronae.models.database.rides.time.DepartureTime
import com.caronae.withu.caronae.models.database.rides.time.Time
import com.caronae.withu.caronae.network.database.addData

/**
* Created by Guilherme on 10/02/2018.
*/

class Mock {

    companion object {
        fun addMockRideToDatabase() {
            addData(DatabaseCollections.RIDES, Ride(
                    Car(
                            "Red",
                            "Corsa",
                            "ASD-1234",
                            4
                    ),
                    Driver("male", 18, "Guilherme", "Prado", "123123"),
                    Local(
                            ArrivalLocal(
                                    "72916048",
                                    "Aguas Lindas",
                                    "23123123",
                                    "123123",
                                    "Rua 11",
                                    "ao lado do",
                                    "GO",
                                    "11"
                            ),
                            DepartureLocal(
                                    "72916048",
                                    "Aguas Lindas",
                                    "23123123",
                                    "123123",
                                    "Rua 11",
                                    "ao lado do",
                                    "GO",
                                    "11"
                            ),
                            "Descrição"
                    ),
                    "25/03/2017",
                    RideTimes(
                            listOf(true, true, false)
                    ),
                    Time(
                            DepartureTime(
                                    "10:30",
                                    "30min"
                            ),
                            "20:30"
                    ),
                    "Descrição",
                    "6$",
                    "Carona tal",
                    3
            ))
        }

    }
}
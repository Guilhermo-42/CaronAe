package com.caronae.withu.caronae.events

import com.google.firebase.firestore.QuerySnapshot

/**
* Created by Guilherme on 10/02/2018.
*/

data class RidesDataRetrieveEvent(val querySnapshot: QuerySnapshot)
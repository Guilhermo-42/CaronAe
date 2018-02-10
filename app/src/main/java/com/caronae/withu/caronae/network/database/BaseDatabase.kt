package com.caronae.withu.caronae.network.database

import android.util.Log
import com.caronae.withu.caronae.events.RidesDataRetrieveEvent
import com.caronae.withu.caronae.models.database.DatabaseCollections
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import org.greenrobot.eventbus.EventBus

/**
* Created by Guilherme on 28/01/2018.
*/

fun addData(collection: DatabaseCollections, data: Any) {
    val db = FirebaseFirestore.getInstance()
    db.collection(collection.toString())
            .add(data)
            .addOnSuccessListener {
                Log.i("data-write", "success")
            }
            .addOnFailureListener {
                Log.i("data-write", it.toString())
            }
}

fun getData(collection: DatabaseCollections): Task<QuerySnapshot> {
    val db = FirebaseFirestore.getInstance()
    return db.collection(collection.toString())
            .get()
            .addOnSuccessListener {
                EventBus.getDefault().post(RidesDataRetrieveEvent(it))
            }
            .addOnFailureListener {
                Log.i("data-get", "failure")
            }
            .addOnCompleteListener {
                Log.i("data-get", it.result.toString())
            }
}
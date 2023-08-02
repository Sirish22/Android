package com.sirish.vehiclerentalapplication.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
        @PrimaryKey
        val _id : String= "",
        val vimage : String? = null,
        val vname : String? = null,
        val vdetails : String? = null,
        val vprice : String? = null
)

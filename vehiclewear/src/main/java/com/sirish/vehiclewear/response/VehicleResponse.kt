package com.sirish.vehiclerentalapplication.response

import com.sirish.vehiclerentalapplication.entity.Vehicle

data class VehicleResponse (
        val success : Boolean? = null,
        val data : Vehicle? = null
        )

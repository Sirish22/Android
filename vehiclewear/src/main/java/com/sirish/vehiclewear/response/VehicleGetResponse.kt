package com.sirish.vehiclerentalapplication.response

import com.sirish.vehiclerentalapplication.entity.Vehicle

data class VehicleGetResponse(
        val success : Boolean? = null,
        val data : MutableList<Vehicle>? = null
)

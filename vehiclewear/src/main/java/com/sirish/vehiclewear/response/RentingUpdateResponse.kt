package com.sirish.vehiclerentalapplication.response

import com.sirish.vehiclerentalapplication.entity.Renting

data class RentingUpdateResponse (
    val success: Boolean? =null,
    val data : Renting? = null
)
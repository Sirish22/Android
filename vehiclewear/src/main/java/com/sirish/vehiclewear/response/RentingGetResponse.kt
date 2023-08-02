package com.sirish.vehiclerentalapplication.response

import com.sirish.vehiclerentalapplication.entity.Renting

class RentingGetResponse (
    val success: Boolean? =null,
    val data : MutableList<Renting>? = null
        )
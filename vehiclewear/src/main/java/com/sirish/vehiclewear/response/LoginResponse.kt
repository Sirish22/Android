package com.sirish.vehiclerentalapplication.response

import com.sirish.vehiclerentalapplication.entity.User

data class LoginResponse (
    val success : Boolean? = null,
    val token : String? = null,
    val data : User? = null
)
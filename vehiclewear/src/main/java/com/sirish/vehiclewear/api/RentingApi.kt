package com.sirish.vehiclerentalapplication.api

import com.sirish.vehiclerentalapplication.response.RentingGetResponse
import com.sirish.vehiclerentalapplication.response.RentingResponse
import retrofit2.http.*

interface RentingApi {
    @GET("/vehicles/showall")
    suspend fun getRenting(
        @Header("authorization") token: String
    ):retrofit2.Response<RentingGetResponse>

    @DELETE("/Mybooking/delete/{id}")
    suspend fun deleteRenting(
        @Header ("authorization") token: String,@Path("id") id:String
    ):retrofit2.Response<RentingResponse>

}
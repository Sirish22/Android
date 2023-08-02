package com.sirish.vehiclerentalapplication.api

import com.sirish.vehiclerentalapplication.entity.Vehicle
import com.sirish.vehiclerentalapplication.response.ImageResponse
import com.sirish.vehiclerentalapplication.response.VehicleGetResponse
import com.sirish.vehiclerentalapplication.response.VehicleResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface VehicleApi {
    @POST("/vehicle/insert")
    suspend fun Insert_Vehicle(
            @Header("Authorization") token: String,
            @Body vehicle: Vehicle
    ): Response<VehicleResponse>


    @GET("/vehicle/showall")
    suspend fun getVehicle(
            @Header("Authorization") token: String
    ):Response<VehicleGetResponse>

    @Multipart
    @PUT("student/{id}/photo")
    suspend fun uploadImage(
            @Header("Authorization") token: String,
            @Path("id") id: String,
            @Part file: MultipartBody.Part
    ): Response<ImageResponse>

    @POST("/vehicle/book")
    suspend fun rent(@Header("authorization")token:String,@Body vehicle: Vehicle):Response<ImageResponse>
}
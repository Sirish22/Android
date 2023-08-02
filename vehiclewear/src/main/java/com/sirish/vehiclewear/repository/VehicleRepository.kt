package com.sirish.vehiclewear.repository

import com.sirish.vehiclerentalapplication.api.MyApiRequest
import com.sirish.vehiclerentalapplication.api.ServiceBuilder
import com.sirish.vehiclerentalapplication.entity.Vehicle
import com.sirish.vehiclerentalapplication.response.ImageResponse
import com.sirish.vehiclerentalapplication.response.VehicleGetResponse
import com.sirish.vehiclerentalapplication.response.VehicleResponse
import okhttp3.MultipartBody

class VehicleRepository: MyApiRequest() {
    val VehicleApi = ServiceBuilder.buildService(com.sirish.vehiclerentalapplication.api.VehicleApi::class.java)

    suspend fun insertVehicle(vehicle : Vehicle): VehicleResponse {
        return apiRequest {
            VehicleApi.Insert_Vehicle(ServiceBuilder.token!!, vehicle)
        }
    }

    suspend fun getVehicle(): VehicleGetResponse {
        return apiRequest {
            VehicleApi.getVehicle(ServiceBuilder.token!!)

        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            VehicleApi.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }

    suspend fun rent(vehicle: Vehicle):ImageResponse{
        return apiRequest {
            VehicleApi.rent(ServiceBuilder.token!!,vehicle)
        }
    }
}



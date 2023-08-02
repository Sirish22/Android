package com.sirish.vehiclewear.repository

import com.sirish.vehiclerentalapplication.api.MyApi
import com.sirish.vehiclerentalapplication.api.MyApiRequest
import com.sirish.vehiclerentalapplication.api.ServiceBuilder
import com.sirish.vehiclerentalapplication.entity.User
import com.sirish.vehiclerentalapplication.response.ImageResponse
import com.sirish.vehiclerentalapplication.response.LoginResponse
import okhttp3.MultipartBody

class UserRepository: MyApiRequest() {
    val myApi = ServiceBuilder.buildService(MyApi::class.java)

    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            myApi.registerUser(user)
        }
    }

    suspend fun checkUser(username : String, password: String): LoginResponse{
        return apiRequest {
            myApi.checkUser(username, password)
        }
    }
    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            myApi.uploadImage( id, body)
        }
    }
}
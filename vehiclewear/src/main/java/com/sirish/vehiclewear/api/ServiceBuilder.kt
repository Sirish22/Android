package com.sirish.vehiclerentalapplication.api

import com.sirish.vehiclerentalapplication.entity.User
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    val BASE_URL = "http://10.0.2.2:90/"
   // val BASE_URL = "http://localhost:90/"    //Unit testing
    var token: String? = null
    var user: User? = null

    val okHttp = OkHttpClient.Builder()

    val retrofitBuilder =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())

    private val retrofit = retrofitBuilder.build()

    //Generic class
    fun <T> buildService (serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}
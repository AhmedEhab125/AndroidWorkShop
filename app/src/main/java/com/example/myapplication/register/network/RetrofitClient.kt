package com.example.myapplication.register.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val apiInstane = Retrofit.Builder().baseUrl("https://identitytoolkit.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val service = apiInstane.create(ApiService::class.java)
    fun getInstance() : ApiService {
        return service
    }

}
package com.example.myapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIServices {
    @GET("/everything?")
    fun getArticls (@Query("q") filter : String,@Query("apiKey") apiKey : String = "53adbd1111984d2aaf607f462d3e85e0")
}
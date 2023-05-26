package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val apiInstane = Retrofit.Builder().baseUrl("https://identitytoolkit.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val service = apiInstane.create(ApiService::class.java)

    private val newsApiInstane = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val newsService = newsApiInstane.create(ApiService::class.java)
    fun getInstance() :ApiService{
        return service
    }
    fun getArticlesInstance() :ApiService{
        return service
    }
}
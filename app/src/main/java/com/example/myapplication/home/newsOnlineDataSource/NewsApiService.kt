package com.example.myapplication.home.newsOnlineDataSource

import com.example.myapplication.model.NewsResponse
import retrofit2.http.GET

interface NewsApiService {
    @GET("v2/top-headlines?country=us&apiKey=8439ad5102b145839c85438bda843c25")
    fun getNewsFromApi():NewsResponse
}
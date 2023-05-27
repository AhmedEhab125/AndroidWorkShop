package com.example.myapplication.home.newsOnlineDataSource

import com.example.myapplication.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines?country=us&apiKey=8439ad5102b145839c85438bda843c25")
    suspend fun getNewsFromApi():NewsResponse

   //" https://newsapi.org/v2/everything?q=apple&apiKey=53adbd1111984d2aaf607f462d3e85e0"
    @GET("v2/everything")
    suspend fun getFilteredArticels (@Query("q") filter : String, @Query("apiKey") apiKey : String = "8439ad5102b145839c85438bda843c25") :NewsResponse
}
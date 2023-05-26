package com.example.myapplication.home.newsNetwork

import com.example.myapplication.model.NewsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsClinet: RemoteDataSource {
    companion object {
        private var myInstance: NewsClinet? = null
        fun getInstance(): NewsClinet? {
            if (myInstance ==null)
                myInstance = NewsClinet()
            return myInstance
        }
    }
    object MyRetrofit {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    object myApiService {
        val api_service: NewsApiService by lazy {
            MyRetrofit.retrofit.create(NewsApiService::class.java)
        }
    }

    override fun getNewsFromApi(): Response<NewsResponse> {
        return myApiService.api_service.getNewsFromApi()
    }
}
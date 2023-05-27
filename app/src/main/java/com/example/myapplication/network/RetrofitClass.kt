package com.example.myapplication.network

import com.example.myapplication.home.newsOnlineDataSource.NewsApiService
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.register.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {
    companion object{
        private val apiInstane = Retrofit.Builder().baseUrl("https://identitytoolkit.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        private val service = apiInstane.create(ApiService::class.java)

        fun getInstance() : ApiService {
            return service
        }
        private var newsInstance: NewsClinet? = null
        fun getNewsInstance(): NewsClinet? {
            if (newsInstance ==null)
                newsInstance = NewsClinet()
            return newsInstance
        }
    }

    object NewsRetrofit {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    object myApiService {
        val api_service: NewsApiService by lazy {
            NewsRetrofit.retrofit.create(NewsApiService::class.java)
        }
    }


}
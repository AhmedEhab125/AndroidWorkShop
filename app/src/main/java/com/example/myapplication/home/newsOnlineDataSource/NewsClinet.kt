package com.example.myapplication.home.newsOnlineDataSource

import com.example.myapplication.model.NewsResponse
import com.example.myapplication.network.RetrofitClass

class NewsClinet: NewsRemoteDataInterface {

    override suspend fun getNewsFromApi(): NewsResponse? {
        return RetrofitClass.myApiService.api_service.getNewsFromApi()
    }

    override suspend fun getFilteredArticles(filterOPerator: String): NewsResponse {
       return RetrofitClass.myApiService.api_service.getFilteredArticels(filterOPerator)
    }
}
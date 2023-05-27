package com.example.myapplication.home.newsOnlineDataSource

import com.example.myapplication.model.NewsResponse

interface NewsRemoteDataInterface {
    suspend fun  getNewsFromApi(): NewsResponse?
    suspend fun getFilteredArticles(filterOPerator :String) : NewsResponse
}
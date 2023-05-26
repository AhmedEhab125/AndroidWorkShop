package com.example.myapplication.home.newsNetwork

import com.example.myapplication.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    fun getNewsFromApi(): Response<NewsResponse>
}
package com.example.myapplication.home.model

import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState

interface NewsRepoInterface {
    suspend fun getNewsFromApi(): ApiState
}
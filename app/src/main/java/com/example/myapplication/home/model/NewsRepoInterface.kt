package com.example.myapplication.home.model

import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles

interface NewsRepoInterface {
    suspend fun getNewsFromApi(): ApiState
    suspend fun getLocalData():List<Articles>
}
package com.example.myapplication.home.newsOnlineDataSource

import com.example.myapplication.model.NewsResponse

interface NewsRemoteDataInterface {
    fun getNewsFromApi(): NewsResponse?
}
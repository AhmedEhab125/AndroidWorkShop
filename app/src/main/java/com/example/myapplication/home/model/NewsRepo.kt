package com.example.myapplication.home.model

import com.example.myapplication.home.newsNetwork.NewsClinet
import com.example.myapplication.home.newsNetwork.RemoteDataSource
import com.example.myapplication.model.NewsResponse
import retrofit2.Response

class NewsRepo(var rs:NewsClinet):NewsRepoInterface {
    var remoteSource:RemoteDataSource = rs

    override fun getNewsFromApi(): Response<NewsResponse> {
        return remoteSource.getNewsFromApi()
    }
}
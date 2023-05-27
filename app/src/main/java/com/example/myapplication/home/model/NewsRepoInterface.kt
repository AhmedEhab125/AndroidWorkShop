package com.example.myapplication.home.model

import com.example.myapplication.DataBaseRepo.DataSourceInter
import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

interface NewsRepoInterface: FilteredArticles , DataSourceInter {
    suspend fun getNewsFromApi(): ApiState
    suspend fun getLocalData():List<Articles>
    suspend fun deleteArticel(favouriteArticles: FavouriteArticles)
}
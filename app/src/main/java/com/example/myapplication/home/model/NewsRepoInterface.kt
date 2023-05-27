package com.example.myapplication.home.model

import com.example.myapplication.DataBaseRepo.DataSourceInter
import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

interface NewsRepoInterface: FilteredArticles , DataSourceInter {
    suspend fun getNewsFromApi(): ApiState
    suspend fun getLocalData():List<Articles>?
    suspend fun insertIntoDataBase(articles: List<Articles>)
    override suspend fun getAllSavedArticles(): List<Articles>
    override  suspend fun saveFavArtivles(articles: FavouriteArticles)
    override suspend fun getFavouriteArticles(): List<FavouriteArticles>
    override suspend fun saveArticleRequest(articles: List<Articles>)
    override suspend fun deleteUnfavouriteData()
}
package com.example.myapplication.database

import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

interface DataBaseInter {
    suspend fun getSavedArticles() : List<Articles>
    suspend fun saveArtivles(articles: List<Articles>)
    suspend fun saveFavArtivles(articles: FavouriteArticles)
    suspend fun getFavouriteArticles() : List<FavouriteArticles>
    suspend fun saveArticleRequest(articles: List<Articles>)
    suspend fun deleteUnfavouriteData()
}

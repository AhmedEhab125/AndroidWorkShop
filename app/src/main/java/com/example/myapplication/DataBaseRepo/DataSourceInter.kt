package com.example.myapplication.DataBaseRepo

import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

interface DataSourceInter {
   suspend fun getAllSavedArticles() : List<Articles>
   suspend fun saveArtivles(articles: List<Articles>)

   suspend fun saveFavArtivles(articles: FavouriteArticles)
   suspend fun getFavouriteArticles() : List<FavouriteArticles>
   suspend fun saveArticleRequest(articles: List<Articles>)
   suspend fun deleteUnfavouriteData()
}

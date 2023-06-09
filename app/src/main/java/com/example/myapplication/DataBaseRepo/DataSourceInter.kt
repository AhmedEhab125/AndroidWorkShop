package com.example.myapplication.DataBaseRepo

import com.example.myapplication.model.Articles

interface DataSourceInter {
   suspend fun getAllSavedArticles() : List<Articles>
   suspend fun saveArtivles(articles: Articles)
   suspend fun getFavouriteArticles() : List<Articles>
}

package com.example.myapplication.DataBaseRepo

import com.example.myapplication.model.Articles

interface DataSourceInter {
   suspend fun getSavedArticles() : List<Articles>
   suspend fun saveArtivles(articles: Articles)
}

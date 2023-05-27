package com.example.myapplication.database

import com.example.myapplication.model.Articles

interface DataBaseInter {
    fun getSavedArticles() : List<Articles>?
    suspend fun saveArtivles(articles: List<Articles>)
    fun getFavouriteArticles():List<Articles>
}
package com.example.myapplication.database

import com.example.myapplication.model.Articles

interface DataBaseInter {
    fun getSavedArticles() : List<Articles>
    fun saveArtivles(articles: Articles)
}
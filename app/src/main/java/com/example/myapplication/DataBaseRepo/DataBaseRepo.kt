package com.example.myapplication.DataBaseRepo

import com.example.myapplication.database.DataBaseInter
import com.example.myapplication.model.Articles

class DataBaseRepo :DataSourceInter {
    override suspend fun getSavedArticles(): List<Articles> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArtivles(articles: Articles) {
        TODO("Not yet implemented")
    }

}
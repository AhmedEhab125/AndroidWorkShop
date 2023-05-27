package com.example.myapplication.DataBaseRepo

import com.example.myapplication.database.DataBaseInter
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.model.Articles

class DataBaseRepo(var articlesDataBase: NewsDataBase.ArticlesDataBase) :DataSourceInter {
    override suspend fun getAllSavedArticles(): List<Articles> {
    return articlesDataBase.articles().getAllArticles()

    }

    override suspend fun saveArtivles(articles: List<Articles>) {
        articlesDataBase.articles().insertArticle(articles)
    }

    override suspend fun getFavouriteArticles(): List<Articles> {
        return articlesDataBase.articles().getFavouriteArticles()
    }


}
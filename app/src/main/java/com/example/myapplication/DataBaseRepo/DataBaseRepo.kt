package com.example.myapplication.DataBaseRepo

import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

class DataBaseRepo(var articlesDataBase: NewsDataBase.ArticlesDataBase) :DataSourceInter {
    override suspend fun getAllSavedArticles(): List<Articles> {
        return articlesDataBase.articles().getAllArticles()

    }

    override suspend fun saveFavArtivles(articles: FavouriteArticles) {
        articlesDataBase.articles().insertFavArticle(articles)
    }

    override suspend fun getFavouriteArticles(): List<FavouriteArticles> {

        return articlesDataBase.articles().getAllFavouriteArticles()
    }
    override suspend fun saveArtivles(articles: List<Articles>) {
        articlesDataBase.articles().insertArticle(articles)
    }


    override suspend fun saveArticleRequest(articles: List<Articles>) {
        articles.forEach { article ->
            articlesDataBase.articles().insertArticle(article)
        }
    }

    override suspend fun deleteUnfavouriteData() {

        articlesDataBase.articles().deleteAllUnFavouriteArticles()


}
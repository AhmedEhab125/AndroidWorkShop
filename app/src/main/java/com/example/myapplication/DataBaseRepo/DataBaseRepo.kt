package com.example.myapplication.DataBaseRepo

import com.example.myapplication.database.DataBaseInter
import com.example.myapplication.database.FavouriteArticlesDAtaBase
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

class DataBaseRepo(var articlesDataBase: NewsDataBase.ArticlesDataBase
, var favouriteArticlesDAtaBase: FavouriteArticlesDAtaBase.FavArticlesDataBase) : DataSourceInter {
    override suspend fun getAllSavedArticles(): List<Articles> {
        return articlesDataBase.articles().getAllArticles()

    }

    override suspend fun saveFavArtivles(articles: FavouriteArticles) {
        favouriteArticlesDAtaBase.favArticles().insertFavArticle(articles)
    }

    override suspend fun getFavouriteArticles(): List<FavouriteArticles> {

        return favouriteArticlesDAtaBase.favArticles().getAllFavouriteArticles()
    }

    override suspend fun saveArticleRequest(articles: List<Articles>) {
        articles.forEach { article ->
            articlesDataBase.articles().insertArticle(article)
        }
    }

    override suspend fun deleteUnfavouriteData() {

        articlesDataBase.articles().deleteAllUnFavouriteArticles()
    }


}
package com.example.myapplication.home.model

import com.example.myapplication.DataBaseRepo.DataBaseRepo
import com.example.myapplication.DataBaseRepo.DataSourceInter
import com.example.myapplication.database.DataBaseInter
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsResponse
import com.example.myapplication.network.RetrofitClass
import com.example.myapplication.register.model.FavouriteArticles

class NewsRepo(var rs: NewsClinet, var articlesDataBase: NewsDataBase.ArticlesDataBase) :
    NewsRepoInterface {
    var remoteSource: NewsRemoteDataInterface = rs
    var localSource: DataBaseInter = fakeDataSourse()
    override suspend fun getNewsFromApi(): ApiState {
        return try {
            ApiState.Success(remoteSource.getNewsFromApi()?.articles)
        } catch (e: Exception) {
            ApiState.Failure(e)
        }
    }

    override suspend fun getLocalData(): List<Articles> {
        return localSource.getSavedArticles()
    }

    override suspend fun getAllSavedArticles(): List<Articles> {
        return articlesDataBase.articles().getAllArticles()

    }

    override suspend fun saveFavArtivles(articles: FavouriteArticles) {
        articlesDataBase.articles().insertFavArticle(articles)
    }

    override suspend fun getFavouriteArticles(): List<FavouriteArticles> {

        return articlesDataBase.articles().getAllFavouriteArticles()
    }

    override suspend fun saveArticleRequest(articles: List<Articles>) {
        articles.forEach { article ->
            articlesDataBase.articles().insertArticle(article)
        }
    }

    override suspend fun deleteUnfavouriteData() {

        articlesDataBase.articles().deleteAllUnFavouriteArticles()
    }

    override suspend fun getFilteredArticles(filterOPerator: String) :ApiState {
       return try {
           ApiState.Success(rs.getFilteredArticles(filterOPerator).articles)
       }catch (e :Exception){
           println(e)
           println("faiilllllllllllllllllllllllllllllllll")
           ApiState.Failure(e)
       }

    }
}
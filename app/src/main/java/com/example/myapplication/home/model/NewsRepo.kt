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

class NewsRepo(var rs:NewsClinet,var articlesDataBase:fakeDataSourse):NewsRepoInterface {
    var remoteSource:NewsRemoteDataInterface = rs
    var localSource: DataBaseInter = articlesDataBase
     override suspend fun getNewsFromApi():ApiState {
         return try{
             val date = remoteSource.getNewsFromApi()?.articles
             insertIntoDataBase(date!!)
             ApiState.Success(date)
         }catch (e:Exception){
             e.printStackTrace()
             ApiState.Failure(e)
         }
    }

    override suspend fun getLocalData(): List<Articles> {
        return localSource.getSavedArticles()
    }

    override suspend fun insertIntoDataBase(articles: List<Articles>) {
       localSource.saveArtivles(articles)
    }

    override suspend fun getAllSavedArticles(): List<Articles> {
        return localSource.getSavedArticles()

    }

    override suspend fun saveFavArtivles(articles: FavouriteArticles) {
        localSource.saveFavArtivles(articles)
    }

    override suspend fun getFavouriteArticles(): List<FavouriteArticles> {

        return localSource.getFavouriteArticles()
    }

    override suspend fun saveArticleRequest(articles: List<Articles>) {
            localSource.saveArtivles(articles)
    }
    override suspend fun deleteUnfavouriteData() {
        localSource.deleteUnfavouriteData()
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

    override suspend fun deleteArticel(favouriteArticles: FavouriteArticles) {
        TODO("Not yet implemented")
    }

    override suspend fun saveArtivles(articles: List<Articles>) {
        localSource.saveArtivles(articles)
    }
}
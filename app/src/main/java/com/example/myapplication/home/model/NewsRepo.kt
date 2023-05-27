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

    override suspend fun getLocalData(): List<Articles>? {
        return localSource.getSavedArticles()
    }

    override suspend fun insertIntoDataBase(articles: List<Articles>) {
       localSource.saveArtivles(articles)
    }
}
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

class NewsRepo(var rs:NewsClinet):NewsRepoInterface {
    var remoteSource:NewsRemoteDataInterface = rs
    var localSource: DataBaseInter = fakeDataSourse()
     override suspend fun getNewsFromApi():ApiState {
         return try{
             ApiState.Success(remoteSource.getNewsFromApi()?.articles)
         }catch (e:Exception){
             ApiState.Failure(e)
         }
    }

    override suspend fun getLocalData(): List<Articles> {
        return localSource.getSavedArticles()
    }
}
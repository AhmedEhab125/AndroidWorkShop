package com.example.myapplication.home.model

import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.home.newsOnlineDataSource.NewsRemoteDataInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.NewsResponse

class NewsRepo(var rs:NewsClinet):NewsRepoInterface {
    var remoteSource:NewsRemoteDataInterface = rs

     override fun getNewsFromApi():ApiState {
         return try{
             ApiState.Success(remoteSource.getNewsFromApi())
         }catch (e:Exception){
             ApiState.Failure(e)
         }
    }
}
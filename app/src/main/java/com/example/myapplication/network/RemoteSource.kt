package com.example.myapplication.network

import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel




class RemoteSource : RemoteSourceInter {

    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData {

    return   RetrofitClient.getInstance().registerUser(requestBody =requestBody ).execute().body()!!

    }
}
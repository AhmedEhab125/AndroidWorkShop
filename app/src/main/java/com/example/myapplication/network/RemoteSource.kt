package com.example.myapplication.network

import android.util.Log
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class RemoteSource : RemoteSourceInter {

    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData {

    return   RetrofitClient.getInstance().registerUser(requestBody =requestBody ).execute().body()

    }
}
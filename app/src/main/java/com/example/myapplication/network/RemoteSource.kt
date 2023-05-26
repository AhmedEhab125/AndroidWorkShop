package com.example.myapplication.network

import android.util.Log
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteSource : RemoteSourceInter {

    override suspend fun registerUser(requestBody: SignUpModel) : Flow<RetriveData?> {

    return   flowOf(RetrofitClient.getInstance().registerUser(requestBody =requestBody ).execute().body())

    }
}
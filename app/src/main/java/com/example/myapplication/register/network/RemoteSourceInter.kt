package com.example.myapplication.register.network

import com.example.myapplication.model.NewsResponse
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface RemoteSourceInter {
    suspend fun registerUser(requestBody: SignUpModel) : RetriveData
}

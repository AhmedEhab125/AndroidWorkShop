package com.example.myapplication.network

import com.example.myapplication.model.ApiState
import com.example.myapplication.model.NewsResponse
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.flow.Flow


interface RemoteSourceInter {
    suspend fun registerUser(requestBody: SignUpModel) : RetriveData
}

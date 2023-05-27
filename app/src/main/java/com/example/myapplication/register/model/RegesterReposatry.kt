package com.example.myapplication.register.model

import com.example.myapplication.model.ApiState
import com.example.myapplication.model.RetriveData
import kotlinx.coroutines.delay

class RegesterReposatry : RegisterInterface{
    override suspend fun getRegisterResponse(user: RegisterUser) : ApiState {
        delay(1000)
       return ApiState.Failure(Exception("Error Register"))
    }
}
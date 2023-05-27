package com.example.myapplication.model

import com.example.myapplication.register.network.RemoteSourceInter

interface RepositoryInterface : RemoteSourceInter {
    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData
    suspend fun getUserNameAndPassword(userName:String,password:String): ApiState

}
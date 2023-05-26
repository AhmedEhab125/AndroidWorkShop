package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser
import com.example.myapplication.register.network.RemoteSourceInter
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface : RemoteSourceInter {
    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData
    suspend fun getUserNameAndPassword(userName:String,password:String): ApiState

}
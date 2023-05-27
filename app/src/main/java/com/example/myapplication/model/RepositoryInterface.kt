package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser
import com.example.myapplication.network.RemoteSourceInter
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
     suspend fun registerUser(requestBody: SignUpModel) : ApiState
    suspend fun getUserNameAndPassword(userName:String,password:String): ApiState

}
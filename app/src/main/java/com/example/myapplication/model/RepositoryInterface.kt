package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser
import com.example.myapplication.network.RemoteSourceInter
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface :RemoteSourceInter{
    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData
    suspend fun getUserNameAndPassword(): LoginUser
}
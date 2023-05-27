package com.example.myapplication.network

import com.example.myapplication.model.*
import kotlinx.coroutines.flow.Flow


interface RemoteSourceInter {
    suspend fun registerUser(requestBody: SignUpModel) : RetriveData

    suspend fun loginUser(loignUserBody : LoginUserModel) : RetriveData
}

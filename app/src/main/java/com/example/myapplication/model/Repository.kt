package com.example.myapplication.model

import com.example.myapplication.register.network.RemoteSourceInter

class Repository(var remoteSourceInter: RemoteSourceInter) :RepositoryInterface {

    override suspend fun registerUser(requestBody: SignUpModel): RetriveData {
       return remoteSourceInter.registerUser(requestBody)
    }

    override suspend fun getUserNameAndPassword(userName: String, password: String): ApiState {
        TODO("Not yet implemented")
    }


}
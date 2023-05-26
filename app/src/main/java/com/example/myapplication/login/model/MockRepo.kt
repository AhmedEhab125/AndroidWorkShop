package com.example.myapplication.login.model

import com.example.myapplication.model.*
import kotlinx.coroutines.delay

class mockRepo: RepositoryInterface {
    override suspend fun registerUser(requestBody: SignUpModel): RetriveData {
        TODO("Not yet implemented")
    }

    override suspend fun getUserNameAndPassword(userName:String,password:String): ApiState {
       delay(1000)
        return if(userName == "Essam" && password == "1234")
            ApiState.Success(LoginResponse())
        else
            ApiState.Failure(Exception("incorrect username or password"))
    }
}
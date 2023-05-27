package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser
import com.example.myapplication.network.RemoteSourceInter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository(var remoteSourceInter: RemoteSourceInter) :RepositoryInterface {

    override suspend fun registerUser(requestBody: SignUpModel): ApiState {
        return try {
            ApiState.Success (remoteSourceInter.registerUser(requestBody))
        }catch (e : java.lang.Exception){
            ApiState.Failure(e)
        }

    }

    override suspend fun loginUser(loginUserBody: LoginUserModel): ApiState {
        return try {
            ApiState.Success (remoteSourceInter.loginUser(loginUserBody))
        }catch (e : java.lang.Exception){
            ApiState.Failure(e)
        }
    }


}
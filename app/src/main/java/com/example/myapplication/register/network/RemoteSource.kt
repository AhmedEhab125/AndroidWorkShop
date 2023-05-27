package com.example.myapplication.register.network

import com.example.myapplication.model.LoginUserModel
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import com.example.myapplication.network.RemoteSourceInter
import com.example.myapplication.network.RetrofitClass


class RemoteSource : RemoteSourceInter {
    override suspend fun registerUser(requestBody: SignUpModel) : RetriveData {

        return RetrofitClass.getInstance().registerUser(requestBody = requestBody)
    }

    override suspend fun loginUser(loignUserBody: LoginUserModel) : RetriveData {
        return RetrofitClass.getInstance().loginUser(loignUserBody)
    }


}
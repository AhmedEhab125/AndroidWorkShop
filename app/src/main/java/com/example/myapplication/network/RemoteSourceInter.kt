package com.example.myapplication.network

import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.flow.Flow


interface RemoteSourceInter {
     fun registerUser(requestBody: SignUpModel) : SignUpModel
}

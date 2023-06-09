package com.example.myapplication.register.model

import com.example.myapplication.model.ApiState
import com.example.myapplication.register.model.RegisterUser

interface RegisterInterface {
    suspend fun getRegisterResponse(user: RegisterUser):ApiState
}
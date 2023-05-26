package com.example.myapplication.network

import com.example.myapplication.model.SignUpModel

interface RemoteSourceInter {
     fun registerUser(requestBody: SignUpModel) : SignUpModel
}

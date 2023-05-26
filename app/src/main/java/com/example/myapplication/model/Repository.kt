package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser

class Repository:RepositoryInterface {
    override suspend fun getUserNameAndPassword():LoginUser {
        return LoginUser("Essam","1234")
    }
}
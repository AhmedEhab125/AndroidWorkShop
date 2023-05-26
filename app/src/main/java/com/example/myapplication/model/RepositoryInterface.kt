package com.example.myapplication.model

import com.example.myapplication.login.loginView.LoginUser

interface RepositoryInterface {
    suspend fun getUserNameAndPassword():LoginUser
}
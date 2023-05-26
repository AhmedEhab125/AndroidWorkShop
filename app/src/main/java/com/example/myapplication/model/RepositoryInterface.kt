package com.example.myapplication.model

import com.example.myapplication.network.RemoteSourceInter

interface RepositoryInterface :RemoteSourceInter{

    suspend fun getUserNameAndPassword():LoginUser
}
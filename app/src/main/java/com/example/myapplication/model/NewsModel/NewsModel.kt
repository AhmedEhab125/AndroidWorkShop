package com.example.myapplication.model

data class NewsModel(

    var status: String? = null,
    var totalResults: Int? = null,
    var articles: ArrayList<Articles> = arrayListOf()

)
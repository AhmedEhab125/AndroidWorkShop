package com.example.myapplication.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class NewsResponse(var status: String, var totalResults: Int, var articles: List<Articles>)

@Entity(tableName = "Articles")
data class Articles(
     var author: String?,
    var title: String?, var description: String?, var url: String?, val urlToImage: String?,
    var publishedAt: String?, var content: String?, var isFavourite: Boolean = false,
     @PrimaryKey(autoGenerate = true)
     val id:Int?=null
)


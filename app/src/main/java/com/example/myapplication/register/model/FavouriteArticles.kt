package com.example.myapplication.register.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "FavouriteArticles")

class FavouriteArticles(
    var author: String?,
    var title: String ?,
    var discription: String ?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?,
    @PrimaryKey(autoGenerate = true)
    val id :Int?=null

)
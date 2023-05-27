package com.example.myapplication.register.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.model.NewsSource
@Entity(tableName = "FavouriteArticles")

class FavouriteArticles(
    @PrimaryKey
    @Embedded
    var source: NewsSource,
    var author: String?,
    var title: String ?,
    var discription: String ?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?

)
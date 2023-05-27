package com.example.myapplication.database.FavouriteDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavArticle(articles: FavouriteArticles): Long

    @Query("SELECT * FROM FavouriteArticles")
    fun getAllFavouriteArticles(): List<FavouriteArticles>
}
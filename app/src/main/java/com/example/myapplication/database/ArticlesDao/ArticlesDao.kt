package com.example.myapplication.database.ArticlesDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.Articles
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articles: List<Articles>)

    @Query("SELECT * FROM Articles")
    fun getAllArticles(): List<Articles>

    @Query("SELECT * FROM Articles WHERE isFavourite = true")
    fun getFavouriteArticles(): List<Articles>
}
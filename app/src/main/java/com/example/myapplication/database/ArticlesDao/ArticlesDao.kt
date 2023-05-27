package com.example.myapplication.database.ArticlesDao

import androidx.room.*
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articles: Articles): Long

    @Query("SELECT * FROM Articles")
    fun getAllArticles(): List<Articles>
    @Query("DELETE  FROM Articles ")
    fun deleteAllUnFavouriteArticles()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavArticle(articles: FavouriteArticles): Long

    @Query("SELECT * FROM FavouriteArticles")
    fun getAllFavouriteArticles(): List<FavouriteArticles>
    @Delete
    suspend fun deleteArticle(articles: FavouriteArticles)
}
package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.ArticlesDao.ArticlesDao
import com.example.myapplication.database.FavouriteDao.FavouriteDao
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

class FavouriteArticlesDAtaBase {
    @Database(entities = arrayOf(FavouriteArticles::class), version = 2)

    abstract class FavArticlesDataBase : RoomDatabase() {
        abstract fun favArticles (): FavouriteDao

        companion object{
            @Volatile
            private var INSTANCE : FavArticlesDataBase?=null
            fun getInstance (context: Context): FavArticlesDataBase {
                return INSTANCE ?: synchronized(this){
                    var instance = Room.databaseBuilder(
                        context.applicationContext, FavArticlesDataBase::class.java ,"FavouriteArticles").build()
                    INSTANCE =instance
                    instance
                }
            }
        }
    }
}
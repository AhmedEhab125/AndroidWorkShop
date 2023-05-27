package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.database.ArticlesDao.ArticlesDao
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

class NewsDataBase {
    @Database(entities = arrayOf(Articles::class, FavouriteArticles::class), version = 1)

    abstract class ArticlesDataBase : RoomDatabase() {
        abstract fun articles (): ArticlesDao

        companion object{
            @Volatile
            private var INSTANCE : ArticlesDataBase?=null
            fun getInstance (context: Context): ArticlesDataBase {
                return INSTANCE ?: synchronized(this){
                    var instance = Room.databaseBuilder(
                        context.applicationContext, ArticlesDataBase::class.java ,"Articles").fallbackToDestructiveMigration().build()
                    INSTANCE =instance
                    instance
                }
            }
        }
    }
}
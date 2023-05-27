package com.example.myapplication.database

import android.content.Context
import com.example.myapplication.database.ArticlesDao.ArticlesDao
import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsSource

class fakeDataSourse(var context: Context? = null) : DataBaseInter {
    companion object{
        private var myInstance:fakeDataSourse? = null
        fun getInstance(ctx: Context):fakeDataSourse?{
            if(myInstance==null)
                myInstance = fakeDataSourse(ctx)
            return myInstance
        }
    }

    val myArticleDoa: ArticlesDao? by lazy {
        context?.let { NewsDataBase.ArticlesDataBase.getInstance(it).articles() }
    }
    override fun getSavedArticles(): List<Articles>? {
        return myArticleDoa?.getAllArticles()
    }

    override suspend fun saveArtivles(articles: List<Articles>) {
        myArticleDoa?.insertArticle(articles)
    }

    override fun getFavouriteArticles(): List<Articles> {
        return listOf()
    }


}
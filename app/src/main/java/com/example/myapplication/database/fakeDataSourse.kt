package com.example.myapplication.database

import android.content.Context
import com.example.myapplication.database.ArticlesDao.ArticlesDao
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class fakeDataSourse(context: Context) : DataBaseInter {
    companion object {
        private var myInstance: fakeDataSourse? = null
        fun getInstance(ctx: Context): fakeDataSourse? {
            if (myInstance == null)
                myInstance = fakeDataSourse(ctx)
            return myInstance
        }
    }

    val myArticleDoa: ArticlesDao by lazy {
        context.let { NewsDataBase.ArticlesDataBase.getInstance(it).articles() }
    }

    override suspend fun getSavedArticles(): List<Articles> {
        return with(Dispatchers.IO) { myArticleDoa.getAllArticles() }
    }

    override suspend fun saveArtivles(articles: List<Articles>) {
        myArticleDoa?.insertArticle(articles)
    }

    override suspend fun saveFavArtivles(articles: FavouriteArticles) {
        myArticleDoa?.insertFavArticle(articles)
    }

    override suspend fun saveArticleRequest(articles: List<Articles>) {
        myArticleDoa?.insertArticle(articles)
    }

    override suspend fun deleteUnfavouriteData() {
        myArticleDoa.deleteAllUnFavouriteArticles()
    }

    override suspend fun getFavouriteArticles(): List<FavouriteArticles> {
        return withContext(Dispatchers.IO){myArticleDoa.getAllFavouriteArticles()}
    }

    override suspend fun deleteArticel(favouriteArticles: FavouriteArticles) {
        return myArticleDoa.deleteArticle(favouriteArticles)
    }


}
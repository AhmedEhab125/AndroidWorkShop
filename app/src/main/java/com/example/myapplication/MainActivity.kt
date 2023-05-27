package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.DataBaseRepo.DataBaseRepo
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsSource
import com.example.myapplication.register.model.FavouriteArticles
import com.example.myapplication.register.model.UserInfoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ( UserInfoDataSource.getInstance().readFromShared(applicationContext) != null){
            println("User Aleardy Login")
        }
        var title = "CNN"
        var discription =
            "Why TikTok is taking months to delete personal US user data from servers outside its Project Texas firewalls, even as its political standing sours"
        var date = "Feb 26, 2023, 16.32 PM"

        var img =
            "https://s.yimg.com/uu/api/res/1.2/LKRH31mzL9wqtcqoQ_lkjw--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2023-04/835a5670-e5f4-11ed-9db6-3febf57b7a4a.cf.jpg"
        var data = Articles(
            NewsSource("1", title), "ahmed",
            title, discription, "", img, date, ""
        )

        var db =DataBaseRepo(NewsDataBase.ArticlesDataBase.getInstance(this))
        lifecycleScope.launch (Dispatchers.IO){
            println("ggggggggggggggggggggggggggggggggggggggggggggg"+db.getAllSavedArticles())
            db.saveArticleRequest(listOf(data) )
            db.saveFavArtivles(FavouriteArticles(
                NewsSource("1", title), "ahmed",
                title, discription, "", img, date, ""
            ))

        }


    }
}
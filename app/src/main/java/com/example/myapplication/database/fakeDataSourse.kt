package com.example.myapplication.database

import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsSource

class fakeDataSourse : DataBaseInter {
    override fun getSavedArticles(): List<Articles> {
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
        return listOf(data, data, data, data, data, data, data, data)
    }

    override fun saveArtivles(articles: Articles) {
    }

    override fun getFavouriteArticles(): List<Articles> {
        return listOf()
    }


}
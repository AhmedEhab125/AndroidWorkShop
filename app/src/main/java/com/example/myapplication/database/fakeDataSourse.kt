package com.example.myapplication.database

import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsSource

class fakeDataSourse :DataBaseInter {
    override fun getSavedArticles(): List<Articles> {
        var img ="https://s.yimg.com/uu/api/res/1.2/LKRH31mzL9wqtcqoQ_lkjw--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2023-04/835a5670-e5f4-11ed-9db6-3febf57b7a4a.cf.jpg"
        return listOf(Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data1", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data2", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data3", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data4", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data5", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data", "fakedata","",img,"3243",""
        ),Articles(NewsSource("1","ahmed fake data"),"ahmed",
            "fake data", "fakedata","","https://s.yimg.com/uu/api/res/1.2/LKRH31mzL9wqtcqoQ_lkjw--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2023-04/835a5670-e5f4-11ed-9db6-3febf57b7a4a.cf.jpg","3243",""
        ))
    }
}
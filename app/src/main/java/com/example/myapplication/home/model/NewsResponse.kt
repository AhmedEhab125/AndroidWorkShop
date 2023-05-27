package com.example.myapplication.model

data class NewsResponse(var status:String,var totalResults:Int,var articles:List<Articles>)

data class Articles(val source:NewsSource,var author:String,
                    var title:String,var description:String,var url:String,val urlToImage:String,
                    var publishedAt:String,var content:String)

data class NewsSource(var id:String,var name:String)
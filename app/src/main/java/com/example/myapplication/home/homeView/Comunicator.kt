package com.example.myapplication.home.homeView

import com.example.myapplication.model.Articles

interface Comunicator {
    fun navigateToHomeScreen(articles: Articles)
}
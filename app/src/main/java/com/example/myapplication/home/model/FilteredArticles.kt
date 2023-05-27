package com.example.myapplication.home.model

import com.example.myapplication.model.ApiState

interface FilteredArticles {
    suspend fun getFilteredArticles(filterOPerator :String) :ApiState
}
package com.example.myapplication.favorite.favoriteViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.home.homeViewModel.HomeViewModel
import com.example.myapplication.home.model.NewsRepoInterface

class FavViewModelFactory(private val irepo: NewsRepoInterface) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {

            FavoriteViewModel(irepo) as T

        } else {

            throw IllegalArgumentException("ViewModel Class not found")

        }
    }
}

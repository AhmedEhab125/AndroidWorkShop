package com.example.myapplication.home.homeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.home.model.NewsRepoInterface
import com.example.myapplication.login.loginViewModel.LoginViewModel


class HomeViewModelFactory(private val irepo: NewsRepoInterface) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            HomeViewModel(irepo) as T

        } else {

            throw IllegalArgumentException("ViewModel Class not found")

        }
    }
}
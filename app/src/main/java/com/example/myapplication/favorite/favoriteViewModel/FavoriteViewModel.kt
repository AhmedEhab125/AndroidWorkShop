package com.example.myapplication.favorite.favoriteViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.home.model.NewsRepoInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel (private val repo: NewsRepoInterface): ViewModel() {
    private var _favData: MutableLiveData<List<FavouriteArticles>> = MutableLiveData()
    val favData: LiveData<List<FavouriteArticles>> = _favData
    fun getFavData(){
        viewModelScope.launch(Dispatchers.IO) {
            _favData.postValue(repo.getFavouriteArticles())
        }
    }
    fun removeFavData(favouriteArticles: FavouriteArticles){
        viewModelScope.launch(Dispatchers.IO) {
        repo.deleteArticel(favouriteArticles)
            getFavData()
        }
    }
}
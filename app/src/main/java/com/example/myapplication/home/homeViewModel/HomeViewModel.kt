package com.example.myapplication.home.homeViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.home.model.NewsRepoInterface
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel (private val repo: NewsRepoInterface): ViewModel() {
    private var _homeData: MutableLiveData<ApiState> = MutableLiveData()
    val homeData: LiveData<ApiState> = _homeData
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun getNewsData(){
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            _homeData.postValue(repo.getNewsFromApi())
            isLoading.postValue(false)
        }

    }

}
package com.example.myapplication.login.loginViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.login.loginView.LoginUser
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.LoginUserModel
import com.example.myapplication.model.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: RepositoryInterface): ViewModel() {
    private var _loginData: MutableLiveData<ApiState> = MutableLiveData()
    val loginData: LiveData<ApiState> = _loginData
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun getUserNameAndPassword(loginUserBody:LoginUserModel){
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            _loginData.postValue(repo.loginUser(loginUserBody))
            isLoading.postValue(false)
        }

    }

}
package com.example.myapplication.register.registerViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.RepositoryInterface
import com.example.myapplication.model.SignUpModel
import com.example.myapplication.network.RemoteSourceInter
import com.example.myapplication.register.model.RegesterReposatry
import com.example.myapplication.register.model.RegisterUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class RegisterViewModel (private val myRepo : RepositoryInterface) : ViewModel () {
  /*  private var _registerResponse = MutableStateFlow<ApiState>(ApiState.Loading)
    var registerResponse : StateFlow<ApiState> = _registerResponse*/

    private var _myResponse : MutableLiveData<ApiState> = MutableLiveData()
     var myResponse : LiveData<ApiState> = _myResponse

   fun getRegesterValidation(user : SignUpModel){
       _myResponse.postValue(ApiState.Loading)
    viewModelScope.launch {
       _myResponse.postValue( myRepo.registerUser(user) )
    }

   }



}
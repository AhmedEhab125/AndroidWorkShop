package com.example.myapplication.register.registerViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.RepositoryInterface
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RegisterViewModel (var iRepo : RepositoryInterface) : ViewModel(){
    private var data: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    var accessList: StateFlow<ApiState> = data
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    fun registerUser(userData : SignUpModel){
        viewModelScope.launch (Dispatchers.IO + coroutineExceptionHandler){
            iRepo.registerUser(userData).catch { e ->
                data.value = ApiState.Failure(e)
            }.collect { retrivedData ->
                data.value = ApiState.Success(retrivedData)
            }

        }
    }
}
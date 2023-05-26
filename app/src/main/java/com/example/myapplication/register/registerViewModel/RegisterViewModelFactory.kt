package com.example.myapplication.register.registerViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.RepositoryInterface

class RegisterViewModelFactory (var context: Context, var iRepo: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            RegisterViewModel(iRepo) as T
        } else {
            throw java.lang.IllegalArgumentException("Cant cast class ")
        }
    }
}
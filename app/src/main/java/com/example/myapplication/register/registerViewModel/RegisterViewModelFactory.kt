package com.example.myapplication.register.registerViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.RepositoryInterface
import com.example.myapplication.network.RemoteSourceInter
import com.example.myapplication.register.model.RegesterReposatry

class RegisterViewModelFactory (private val myrepo: RepositoryInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            RegisterViewModel(myrepo) as T
        } else {
            throw java.lang.IllegalArgumentException(" ViewModel Class not Found")
        }
    }
}
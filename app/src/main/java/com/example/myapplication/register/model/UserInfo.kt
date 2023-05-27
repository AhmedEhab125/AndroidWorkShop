package com.example.myapplication.register.model

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.model.RetriveData
import com.google.gson.Gson

class UserInfoDataSource() {
  lateinit private var sharedPreferences : SharedPreferences

    companion object {
        @Volatile
        private var INSTANCE: UserInfoDataSource? = null

        fun getInstance(): UserInfoDataSource {
            return INSTANCE ?: synchronized(this) {
               val instance = UserInfoDataSource()
                INSTANCE = instance
                instance
            }
        }

    }


  private  fun createUserInvoShared(context: Context) {
        sharedPreferences =context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
    }


    fun writeInShared(context: Context,retriveData: RetriveData) {
        sharedPreferences =context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putString("userData", Gson().toJson(retriveData))
            apply()
        }

    }


    fun readFromShared(context: Context): RetriveData? {
        createUserInvoShared(context)
        return Gson().fromJson(sharedPreferences.getString("userData", ""), RetriveData::class.java)
    }
}
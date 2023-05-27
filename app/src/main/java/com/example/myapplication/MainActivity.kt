package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.DataBaseRepo.DataBaseRepo
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.home.homeView.HomeFragment
import com.example.myapplication.login.loginView.LoginFragment
import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsSource
import com.example.myapplication.register.model.FavouriteArticles
import com.example.myapplication.register.model.UserInfoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ( UserInfoDataSource.getInstance().readFromShared(applicationContext) != null){
            println("User Aleardy Login")
            navigateToHomeScreen()
        } else{
            var loginFragment  = LoginFragment()
            var transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container,loginFragment)
                .commit()
        }




    }


    fun navigateToHomeScreen(){
        var homeFragment  = HomeFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,homeFragment)
            .commit()
    }
}
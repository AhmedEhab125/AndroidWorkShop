package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.register.model.UserInfoDataSource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ( UserInfoDataSource.getInstance().readFromShared(applicationContext) != null){
            println("User Aleardy Login")
        }


    }
}
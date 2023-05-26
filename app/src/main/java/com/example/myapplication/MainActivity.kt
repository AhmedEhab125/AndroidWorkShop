package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.model.SignUpModel
import com.example.myapplication.network.RemoteSource
import com.example.myapplication.network.RemoteSourceInter
import com.example.myapplication.register.model.UserInfoDataSource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ( UserInfoDataSource.getInstance().readFromShared(applicationContext) != null){
            Toast.makeText(applicationContext,"User Alerady Login",Toast.LENGTH_LONG).show()
            println("User Aleardy Login")
        }


    }
}
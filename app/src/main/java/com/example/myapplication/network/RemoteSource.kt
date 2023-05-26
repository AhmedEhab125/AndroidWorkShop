package com.example.myapplication.network

import android.util.Log
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteSource : RemoteSourceInter {

    override  fun registerUser(requestBody: SignUpModel) :SignUpModel {

            RetrofitClient.getInstance().registerUser(requestBody =requestBody ).enqueue(object :Callback<RetriveData>{
                override fun onResponse(call: Call<RetriveData>, response: Response<RetriveData>) {
                    println(response.body()?.displayName)
                }

                override fun onFailure(call: Call<RetriveData>, t: Throwable) {
                    t.printStackTrace()
                }

            })


    return SignUpModel()
    }
}
package com.example.myapplication.network

import com.example.myapplication.model.LoginUserModel
import com.example.myapplication.model.RetriveData
import com.example.myapplication.model.SignUpModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/v1/accounts:signUp?key=AIzaSyAVRNpZKTubdM9mp3L9HaE8XGj09eNoV1o")
   suspend fun registerUser(@Body requestBody: SignUpModel , @Query ("key")  key : String) :RetriveData

   @POST("/v1/accounts:signInWithPassword")
    suspend fun loginUser(@Body loginBody : LoginUserModel , @Query ("key")  key : String ) : RetriveData

    /*?key=AIzaSyAVRNpZKTubdM9mp3L9HaE8XGj09eNoV1o*/

}
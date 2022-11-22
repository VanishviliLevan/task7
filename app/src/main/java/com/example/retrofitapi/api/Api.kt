package com.example.retrofitapi.api

import com.example.retrofitapi.models.EachUserResponse
import com.example.retrofitapi.models.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    fun getUsers(@Query("page") page:String): Call<UsersResponse>

    @GET("users/{user}")
    fun getEachUser(@Path("user") user:Int): Call<EachUserResponse>



}
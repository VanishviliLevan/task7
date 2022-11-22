package com.example.retrofitapi.models

import com.google.gson.annotations.SerializedName

data class UserData (
    val id : Int,
    val email : String,
    @SerializedName("first_name")
    val first_name:String,
    @SerializedName("last_name")
    val last_name :String,
    val avatar :String
)
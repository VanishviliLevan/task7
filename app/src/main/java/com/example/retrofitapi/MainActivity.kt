package com.example.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapi.adapter.UsersAdapter
import com.example.retrofitapi.api.RetrofitClient
import com.example.retrofitapi.models.UserData
import com.example.retrofitapi.models.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var allusers:RecyclerView
    private var list = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var page = "2"

        showUsers(page)
    }


    private fun showUsers(page:String){

        allusers = findViewById(R.id.all_users)
        allusers.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getUsers(page).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                val listResponse = response.body()?.data
                listResponse?.let{list.addAll(it)}

                val adapter = UsersAdapter(list)
                allusers.adapter = adapter

            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("RetroFail",t.message.toString())
            }


        })


    }



}
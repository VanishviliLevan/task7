package com.example.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.retrofitapi.api.RetrofitClient
import com.example.retrofitapi.models.EachUserResponse
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class DetailsActivity : AppCompatActivity() {

    private lateinit var fullName:TextView
    private lateinit var email:TextView
    private lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

       val id = intent.getIntExtra("id",1)

        showDetailUser(id)

    }

    private fun showDetailUser(id: Int){

        fullName = findViewById(R.id.detailFullName)
        email = findViewById(R.id.detailEmail)
        img = findViewById(R.id.detailImg)


        RetrofitClient.instance.getEachUser(id).enqueue(object :Callback<EachUserResponse>{
            override fun onResponse(
                call: Call<EachUserResponse>,
                response: Response<EachUserResponse>
            ) {

                val data = response.body()?.data

                if (data != null) {
                    fullName.text = data.firstName + " " + data.lastName
                    email.text = data.email

                    Picasso.get()
                        .load(data.avatar)
                        .into(img)
                }




            }

            override fun onFailure(call: Call<EachUserResponse>, t: Throwable) {
                Log.e("Detail User", t.message.toString())
            }


        })



    }

}
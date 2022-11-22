package com.example.retrofitapi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapi.DetailsActivity
import com.example.retrofitapi.R
import com.example.retrofitapi.models.UserData
import com.squareup.picasso.Picasso


class UsersAdapter (private val users_list: ArrayList<UserData>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val id :TextView = itemView.findViewById(R.id.id)
        val fullName :TextView = itemView.findViewById(R.id.full_name)
        val email:TextView = itemView.findViewById(R.id.email)
        val img :ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_user,parent,false)
        return  UsersViewHolder(view)
    }

    override fun getItemCount() = users_list.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val currentUser = users_list[position]

        holder.id.text = "ID : ${currentUser.id.toString()}"
        holder.fullName.text = currentUser.first_name + " " + currentUser.last_name
        holder.email.text = currentUser.email

        Picasso.get()
            .load(currentUser.avatar)
            .into(holder.img)

        holder.itemView.setOnClickListener{

            val context = holder.itemView.context

            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra("id",currentUser.id)
            context.startActivity(intent)
        }

    }


}
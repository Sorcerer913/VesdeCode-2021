package com.maximemelyanov.vezdecode2021.ui.recyclerview

import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.maximemelyanov.vezdecode2021.R
import com.maximemelyanov.vezdecode2021.model.VKUser
import com.maximemelyanov.vezdecode2021.model.VKUsers


class CustomRecyclerViewAdapter(context: Context?, private val users: List<VKUser>) :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.friend_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)
        val (image: String?, name: String) = Pair(user?.photo_200, user?.firstName + "\n" + user?.lastName)
        if (image != null){
            Glide.with(holder.image).load(image).into(holder.image)
        }
        holder.name.text = name
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val name: TextView

        init {
            image = view.findViewById(R.id.first_element)
            name = view.findViewById(R.id.second_element)
        }
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}
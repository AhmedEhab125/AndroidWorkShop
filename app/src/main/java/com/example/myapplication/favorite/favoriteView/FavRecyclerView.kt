package com.example.myapplication.favorite.favoriteView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FavIteamBinding
import com.example.myapplication.model.Articles
import com.example.myapplication.model.NewsModel

class FavRecyclerView(var newsList: List<Articles>) :
    RecyclerView.Adapter<FavRecyclerView.ViewHolder>() {
    lateinit var binding: FavIteamBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        binding = FavIteamBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvFavTitle.text= newsList[position].title
        holder.binding.tvFavDiscribtion.text = newsList[position].description
        Glide.with(binding.root).load(newsList[position].urlToImage).into(holder.binding.ivFavNews)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
    fun setArticlsList( newsList: List<Articles>){
        this.newsList=newsList
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: FavIteamBinding) : RecyclerView.ViewHolder(binding.root)
}
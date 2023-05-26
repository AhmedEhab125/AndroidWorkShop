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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding = FavIteamBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setArticleData(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setArticlsList(newsList: List<Articles>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: FavIteamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setArticleData(articles: Articles) {
            binding.tvFavTitle.text = articles.title
            binding.tvFavDiscribtion.text = articles.description
            Glide.with(binding.root).load(articles.urlToImage).into(binding.ivFavNews)
        }
    }
}
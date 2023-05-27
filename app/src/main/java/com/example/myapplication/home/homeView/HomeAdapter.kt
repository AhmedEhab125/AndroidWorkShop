package com.example.myapplication.home.homeView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FavIteamBinding
import com.example.myapplication.model.Articles

class HomeAdapter(private val news:List<Articles>):RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
private lateinit var binding:FavIteamBinding
private lateinit var context:Context
    class MyViewHolder(val viewBinding: FavIteamBinding):RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = FavIteamBinding.inflate(inflater,parent,false)
        context=parent.context
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return news.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var article = news[position]

            }
}
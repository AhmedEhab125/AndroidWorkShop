package com.example.myapplication.favorite.favoriteView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment(){
    lateinit var binding: FragmentFavouriteBinding
    lateinit var favAdapter :FavRecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favAdapter = FavRecyclerView(listOf())
        binding.rvFavNews.adapter =  favAdapter
        binding.rvFavNews.layoutManager = LinearLayoutManager(requireContext())
        fakeDataSourse().getSavedArticles()?.let { favAdapter.setArticlsList(it) }
    }
}
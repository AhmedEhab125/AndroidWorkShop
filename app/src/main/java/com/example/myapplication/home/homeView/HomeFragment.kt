package com.example.myapplication.home.homeView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.favorite.favoriteView.FavRecyclerView
import com.example.myapplication.home.homeViewModel.HomeViewModel
import com.example.myapplication.home.homeViewModel.HomeViewModelFactory
import com.example.myapplication.home.model.NewsRepo
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: FavRecyclerView
    private lateinit var manager:LayoutManager
    private lateinit var homeFactory:HomeViewModelFactory
    private lateinit var homeViewModel:HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        manager = LinearLayoutManager(context)
        homeFactory = HomeViewModelFactory(NewsRepo(NewsClinet()))
        homeViewModel = ViewModelProvider(this,homeFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getNewsData()
        homeViewModel.homeData.observe(viewLifecycleOwner){
            when(it){
                is ApiState.Success<*> -> {
                    var list = it.date as List<Articles>
                    print(list)
                    adapter = FavRecyclerView(list)
                    binding.homeRV.layoutManager = manager
                    binding.homeRV.adapter = adapter
                }
                else -> {}
            }
        }


    }


}
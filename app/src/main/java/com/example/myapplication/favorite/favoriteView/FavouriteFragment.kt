package com.example.myapplication.favorite.favoriteView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.databinding.FragmentFavouriteBinding
import com.example.myapplication.favorite.favoriteViewModel.FavViewModelFactory
import com.example.myapplication.favorite.favoriteViewModel.FavoriteViewModel
import com.example.myapplication.home.homeViewModel.HomeViewModel
import com.example.myapplication.home.homeViewModel.HomeViewModelFactory
import com.example.myapplication.home.model.NewsRepo
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles

class FavouriteFragment : Fragment() ,AddtoFavouite{
    lateinit var binding: FragmentFavouriteBinding
    lateinit var favAdapter :FavRecyclerView
    private lateinit var favFactory: FavViewModelFactory
    private lateinit var favViewModel: FavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater)
        // Inflate the layout for this fragment
        favFactory = FavViewModelFactory(
            NewsRepo(
                NewsClinet(),
                NewsDataBase.ArticlesDataBase.getInstance(requireContext()))
        )
        favViewModel = ViewModelProvider(this,favFactory).get(FavoriteViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favAdapter = FavRecyclerView(listOf(),this)

        binding.rvFavNews.layoutManager = LinearLayoutManager(requireContext())
        favAdapter.setArticlsList(fakeDataSourse().getSavedArticles())
        favViewModel.getFavData()
        favViewModel.favData.observe(viewLifecycleOwner){list->
            var articlesList = mutableListOf<Articles>()
            list.forEach {
                articlesList.add(Articles(it.source,it.author,it.title,it.discription,it.url,it.urlToImage,it.publishedAt,it.content))
            }
            binding.rvFavNews.adapter =  favAdapter
            favAdapter.setArticlsList(articlesList)
        }
    }

    override fun add(articles: Articles) {
    favViewModel.removeFavData(
        FavouriteArticles(articles.source,articles.author,articles.title
    ,articles.discription,articles.url,articles.urlToImage,articles.publishedAt,articles.content)
    )
    }
}
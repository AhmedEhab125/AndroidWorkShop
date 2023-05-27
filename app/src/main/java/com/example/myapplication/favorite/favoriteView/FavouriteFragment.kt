package com.example.myapplication.favorite.favoriteView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.database.NewsDataBase
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.databinding.FragmentFavouriteBinding
import com.example.myapplication.details.detailsView.DetailsFragment
import com.example.myapplication.favorite.favoriteViewModel.FavViewModelFactory
import com.example.myapplication.favorite.favoriteViewModel.FavoriteViewModel
import com.example.myapplication.home.homeView.Comunicator
import com.example.myapplication.home.homeViewModel.HomeViewModel
import com.example.myapplication.home.homeViewModel.HomeViewModelFactory
import com.example.myapplication.home.model.NewsRepo
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.model.Articles
import com.example.myapplication.register.model.FavouriteArticles
import kotlinx.coroutines.launch
import org.json.JSONObject


class FavouriteFragment : Fragment(),AddtoFavouite, Comunicator {
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
                fakeDataSourse(requireContext())
        ))
        favViewModel = ViewModelProvider(this,favFactory).get(FavoriteViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favAdapter = FavRecyclerView(listOf(),this)
        binding.rvFavNews.adapter =  favAdapter
        binding.rvFavNews.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            favAdapter.setArticlsList(fakeDataSourse(requireContext()).getFavouriteArticles().map { Articles(it.author,it.title,it.discription,it.url,
                it.urlToImage,it.publishedAt,it.content,isFavourite = true) })
        }
        favViewModel.favData.observe(viewLifecycleOwner){list->
            var articlesList = mutableListOf<Articles>()
            list.forEach {
                articlesList.add(Articles(it.author,it.title,it.discription,it.url,it.urlToImage,it.publishedAt,it.content))
            }
            binding.rvFavNews.adapter =  favAdapter
            favAdapter.setArticlsList(articlesList)
        }
    }
    override fun add(articles: Articles) {
        favViewModel.removeFavData(
            FavouriteArticles(articles.author,articles.title
                ,articles.description,articles.url,articles.urlToImage,articles.publishedAt,articles.content)
        )
    }
    override fun navigateToDetalisScreen(articles: Articles) {
        val args = Bundle()
        args.putString("articel", parseToJson(articles))
        var detailsFragment  = DetailsFragment()
        detailsFragment.arguments = args
        var transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,detailsFragment)
        transaction.addToBackStack(null)
            .commit()
    }



    fun parseToJson(articles: Articles):String{
        val json = JSONObject()
        json.put("author", articles.author);
        json.put("title", articles.title)
        json.put("content", articles.content)
        json.put("urlToImage", articles.urlToImage)
        json.put("publishedAt", articles.publishedAt)
        return  json.toString()
    }
}
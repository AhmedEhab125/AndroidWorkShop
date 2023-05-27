package com.example.myapplication.favorite.favoriteView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.databinding.FragmentFavouriteBinding


import com.example.myapplication.details.detailsView.DetailsFragment
import com.example.myapplication.home.homeView.Comunicator
import com.example.myapplication.model.Articles
import kotlinx.coroutines.launch
import org.json.JSONObject

class FavouriteFragment : Fragment() , Comunicator {
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
        favAdapter = FavRecyclerView(listOf(),this)
        binding.rvFavNews.adapter =  favAdapter
        binding.rvFavNews.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            favAdapter.setArticlsList(fakeDataSourse(requireContext()).getSavedArticles())

        }

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
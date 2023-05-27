package com.example.myapplication.home.homeView

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Html
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.database.fakeDataSourse
import com.example.myapplication.databinding.FragmentHomeBinding

import com.example.myapplication.details.detailsView.DetailsFragment
import com.example.myapplication.favorite.favoriteView.AddtoFavouite
import com.example.myapplication.favorite.favoriteView.FavRecyclerView
import com.example.myapplication.favorite.favoriteView.FavouriteFragment
import com.example.myapplication.home.homeViewModel.HomeViewModel
import com.example.myapplication.home.homeViewModel.HomeViewModelFactory
import com.example.myapplication.home.model.NewsRepo
import com.example.myapplication.home.newsOnlineDataSource.NewsClinet
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Articles
import com.example.myapplication.model.RetriveData
import com.example.myapplication.register.model.UserInfoDataSource
import com.example.myapplication.network.NetworkConectivityObserver
import com.example.myapplication.network.NetworkObservation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.json.JSONObject

class HomeFragment : Fragment(),Comunicator,AddtoFavouite {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: FavRecyclerView
    private lateinit var manager:LayoutManager
    private lateinit var homeFactory:HomeViewModelFactory
    private lateinit var homeViewModel:HomeViewModel
    private lateinit var progressDialog: ProgressDialog
    lateinit var networkObservation : NetworkObservation
    var lastRequest = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("loading")
        manager = LinearLayoutManager(context)
        adapter = FavRecyclerView(listOf(),this)
        homeFactory = HomeViewModelFactory(NewsRepo(NewsClinet(), fakeDataSourse(binding.root.context)))
        homeViewModel = ViewModelProvider(this,homeFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showFavFAB.setOnClickListener {
            moveToFavScreen()
        }


        networkObservation = NetworkConectivityObserver(requireContext())
         lifecycleScope.launch {
             networkObservation.observeOnNetwork().collectLatest {
                 when(it.name){
                      "Avaliavle" -> {
                          if (!lastRequest){
                              showInternetDialog()
                          }
                       Log.i("Internet",it.name)

                     }
                     "Lost" -> {
                         Log.i("Internet",it.name)

                     }
                 }
         }
         }
        homeViewModel.getNewsData()
        homeViewModel.isLoading.observe(viewLifecycleOwner){
            when(it){
                true -> {progressDialog.show()}
                else -> {progressDialog.hide()}
            }
        }
        homeViewModel.localData.observe(viewLifecycleOwner){
                         adapter.setArticlsList(it)
                         binding.homeRV.layoutManager = manager
                         binding.homeRV.adapter = adapter
                     }
        homeViewModel.homeData.observe(viewLifecycleOwner) {
            when (it) {
                is ApiState.Success<*> -> {
                    var list = it.date as List<Articles>
                    adapter.setArticlsList(list)
                    binding.homeRV.layoutManager = manager
                    binding.homeRV.adapter = adapter
                }
                is ApiState.Failure -> {
                    lastRequest = false
                    Toast.makeText(requireContext(),it.err.message, Toast.LENGTH_LONG).show()
                     homeViewModel.getOfflineData()

                }
                else -> {}
            }
            homeViewModel.searchData.observe(viewLifecycleOwner) {
                when (it) {
                    is ApiState.Success<*> -> {
                        var list = it.date as List<Articles>
                        adapter.setArticlsList(list)
                        binding.homeRV.layoutManager = manager
                        binding.homeRV.adapter = adapter
                    }
                    is ApiState.Failure -> {
                        Toast.makeText(requireContext(), it.err.message, Toast.LENGTH_LONG).show()

                    }
                    else -> {}
                }
            }

            binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
                        homeViewModel.filterWithKey(query)
                    } else {
                        homeViewModel.getNewsData()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText != null && newText.length > 0) {
                        homeViewModel.filterWithKey(newText)
                    } else {
                        homeViewModel.getNewsData()
                    }
                    return true
                }
            })
            binding.ivLogout.setOnClickListener {
                clearUserData()
            }
        }
    }

    private fun moveToFavScreen() {
        var favFragment  = FavouriteFragment()
        var transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,favFragment)
            .addToBackStack(null)
            .commit()
    }

    fun clearUserData(){
        homeViewModel.clearCashedData()
         UserInfoDataSource().deleteCash(requireContext(), RetriveData())
        navigateTologinScreen()
    }
    fun navigateTologinScreen(){
        (activity as MainActivity).navigateToLoginScreen()
    }
    override fun navigateToDetalisScreen(articles: Articles){
        val args = Bundle()
        args.putString("articel", parseToJson(articles))
        var detailsFragment  = DetailsFragment()
        detailsFragment.arguments = args
        var transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,detailsFragment)
            .addToBackStack(null)
            .commit()
    }

    fun retry(){
        //calling setting data ()
        // Ahmead's Logic here
        Log.i("Retray","Done")
        homeViewModel.getNewsData()

    }


    fun showInternetDialog() {
        val retry = "Retray"
        val builder = AlertDialog.Builder(context)
        val message = "There Is No Internet Connection, Please Press Retry"
        builder.setMessage(Html.fromHtml("<font color='#0000'>$message</font>"))
        val title ="Check Conniction"
        builder.setTitle(Html.fromHtml("<font color='#0000'>$title</font>"))
        builder.setCancelable(false)
        builder.setPositiveButton(Html.fromHtml("<font color='#0000'>$retry</font>"),
            { dialog: DialogInterface?, which: Int ->
               retry()
            })


        val alertDialog = builder.create()

        alertDialog.show()
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

    override fun add(articles: Articles) {
        println("sssssssssssssssssssssssssssssssssssss"+articles)
       homeViewModel.addToFav(articles)
    }


}
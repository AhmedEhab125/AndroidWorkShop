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
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
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
import com.example.myapplication.network.NetworkConectivityObserver
import com.example.myapplication.network.NetworkObservation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
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
        homeFactory = HomeViewModelFactory(NewsRepo(NewsClinet()))
        homeViewModel = ViewModelProvider(this,homeFactory).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        homeViewModel.homeData.observe(viewLifecycleOwner){
            when(it){
                is ApiState.Success<*> -> {
                    var list = it.date as List<Articles>
                    print(list)
                    adapter = FavRecyclerView(list)
                    binding.homeRV.layoutManager = manager
                    binding.homeRV.adapter = adapter
                }
                is ApiState.Failure -> {
                    lastRequest = false
                    Toast.makeText(requireContext(),it.err.message, Toast.LENGTH_LONG).show()
                     homeViewModel.getOfflineData()
                     homeViewModel.localData.observe(viewLifecycleOwner){
                         adapter = FavRecyclerView(it)
                         binding.homeRV.layoutManager = manager
                         binding.homeRV.adapter = adapter
                     }
                    //progressDialog.hide()
                }
                else -> {}
            }
        }


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



}
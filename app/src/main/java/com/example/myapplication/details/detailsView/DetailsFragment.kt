package com.example.myapplication.details.detailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentDetailsBinding
import org.json.JSONObject





class DetailsFragment : Fragment() {
    private lateinit var binding:FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        val value = args?.getString("articel")
        parseFromStringToJson(value)


    }
    private fun parseFromStringToJson(value:String?){
        val jsonObject = JSONObject(value)
        val author = jsonObject.getString("author")
        val title = jsonObject.getString("title")
        val content = jsonObject.getString("content")
        val urlToImage = jsonObject.getString("urlToImage")
        val publishedAt = jsonObject.getString("publishedAt")
        binding.dAuther.text = author
        binding.dTitle.text = title
        binding.dDescription.text = content
        binding.dDate.text = publishedAt
        Glide.with(binding.root).load(urlToImage).into(binding.dImg)
    }

}
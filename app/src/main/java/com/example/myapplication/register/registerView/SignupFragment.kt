package com.example.myapplication.register.registerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignupBinding
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.RetriveData
import com.example.myapplication.register.model.RegesterReposatry
import com.example.myapplication.register.model.RegisterUser
import com.example.myapplication.register.registerViewModel.RegisterViewModel
import com.example.myapplication.register.registerViewModel.RegisterViewModelFactory
import com.example.myapplication.utility.RegisterValidation
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class SignupFragment : Fragment() {
   lateinit var binding : FragmentSignupBinding
   var validation = RegisterValidation()
  lateinit var registerModel : RegisterViewModel
  lateinit var registerFactory : RegisterViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerFactory = RegisterViewModelFactory(RegesterReposatry())
        registerModel =
            ViewModelProvider(requireActivity(), registerFactory).get(RegisterViewModel::class.java)

        observeResponse()

        binding.signUpBtn.setOnClickListener {
            binding.emailValidation.text = ""
            binding.passValidation.text = ""
            binding.confPassValidation.text = ""
            binding.nameValidation.text = ""
            var isFalid = true
            var userName = binding.namePlanText.text.toString()
            var userEmail = binding.emailPlainText.text.toString()
            var userPassword = binding.passPlainText.text.toString()
            var userConfPassword = binding.confrmPassTextPlain.text.toString()
            if (validation.isEmpty(userName)) {
                binding.nameValidation.text = "Please Enter Your Name"
                isFalid = false
            }
            if (validation.isEmpty(userEmail)) {
                binding.emailValidation.text = "Please Enter Your Email"
                isFalid = false
            }
            if (!validation.isEmailValid(userEmail)) {
                binding.emailValidation.text = "Please Enter Valid Email"
                isFalid = false
            }
            if (validation.isEmpty(userConfPassword)) {
                binding.passValidation.text = "Please Enter Your Password"
                isFalid = false
            }
            if (userPassword.length < 8) {
                binding.passValidation.text = "Please Enter Valid Password"
                isFalid = false
            }
            if (validation.isEmpty(userConfPassword)) {
                binding.confPassValidation.text = "Please Cpnform Your Password"
                isFalid = false
            }
            if (!validation.isPassMatching(userPassword, userConfPassword)) {
                binding.confPassValidation.text = "Password Not Matchs"
                isFalid = false
            }
            if (isFalid) {
                var user = RegisterUser(userName, userEmail, userPassword, true)
                registerModel.getRegesterValidation(user)

            }

        }
    }



    fun observeResponse() {
        registerModel.myResponse.observe(viewLifecycleOwner) {
            when (it) {
                is ApiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is ApiState.Success<*> -> {
                    val snakbar = Snackbar.make(
                        requireView(),
                        "Success",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null)
                    snakbar.show()
                    binding.progressBar.visibility = View.GONE
                }

                is ApiState.Failure -> {
                    val snakbar = Snackbar.make(
                        requireView(),
                        it.err.localizedMessage,
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null)
                    snakbar.show()
                    binding.progressBar.visibility = View.GONE
                }

            }


        }
    }

}
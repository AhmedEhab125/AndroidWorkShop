package com.example.myapplication.login.loginView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.login.loginViewModel.LoginViewModel
import com.example.myapplication.login.loginViewModel.LoginViewModelFactory
import com.example.myapplication.model.Repository
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener{
            var email = binding.loginEmail.text
            var password = binding.loginEmail.text
            if(email.isNullOrEmpty()){
                binding.emailWarning.text = "Invalid to set the field Empty"
            }
            if(password.isNullOrEmpty()){
                binding.passwordWarning.text = "Invalid to set the field Empty"
            }
            if(!email.isNullOrEmpty() && ! password.isNullOrEmpty()){
                var factory = LoginViewModelFactory(Repository())
                var viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
                viewModel.getUserNameAndPassword()
                viewLifecycleOwner.lifecycleScope.launch{
                    viewModel.loginData.observe(viewLifecycleOwner) { data ->
                        print(data.name+" "+data.password)
                    }
                }
            }
        }

    }



}
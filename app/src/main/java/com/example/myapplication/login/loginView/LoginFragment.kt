package com.example.myapplication.login.loginView

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.login.loginViewModel.LoginViewModel
import com.example.myapplication.login.loginViewModel.LoginViewModelFactory
import com.example.myapplication.model.ApiState
import com.example.myapplication.model.Repository
import com.example.myapplication.model.mockRepo
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var progressDialog: ProgressDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var factory = LoginViewModelFactory(mockRepo())
        var viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("loading")
            viewModel.loginData.observe(viewLifecycleOwner) { data ->
                when(data){
                    is ApiState.Success<*> ->{
                        Log.i("Emessage", "welcome ")
                        progressDialog.hide()
                        Toast.makeText(requireContext(),"Welcome",Toast.LENGTH_LONG).show()
                    }
                    is ApiState.Failure -> {
                       Toast.makeText(requireContext(),data.err.message,Toast.LENGTH_LONG).show()
                        Log.i("Emessage", "error")
                        progressDialog.hide()
                    }
                    else -> {}
                }
            }
        binding.loginBtn.setOnClickListener{
            progressDialog.show()
            var email = binding.loginEmail.text.toString()
            var password = binding.passLogin.text.toString()
            if(email.isNullOrEmpty()){
                binding.emailWarning.text = "Invalid to set the field Empty"
            }else{
                binding.emailWarning.text = ""
            }
            if(password.isNullOrEmpty()){
                binding.passwordWarning.text = "Invalid to set the field Empty"
            }else{
                binding.passwordWarning.text = ""
            }
            if(!email.isNullOrEmpty() && ! password.isNullOrEmpty()){
                Log.i("Emessage", email+" "+password)
                viewModel.getUserNameAndPassword(email,password)

            }
        }

    }



}
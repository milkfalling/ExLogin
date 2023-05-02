package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentLoginSuccessBinding
import com.example.exlogin.viewmodel.LoginSuccessViewModel
import com.example.exlogin.viewmodel.RegisterSuccessViewModel

class register_success : Fragment() {

    private lateinit var binding: FragmentLoginSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginSuccessBinding.inflate(inflater,container,false)
        binding.viewModel = LoginSuccessViewModel()
        binding.lifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding){
            txtWait.setOnClickListener{
                Navigation.findNavController(it).navigate(R.id.friendsFragment)
            }
        }
    }

}
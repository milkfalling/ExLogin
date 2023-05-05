package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentLoginSuccessBinding
import com.example.exlogin.model.Friend
import com.example.exlogin.model.Member
import com.example.exlogin.viewmodel.LoginSuccessViewModel

class login_success : Fragment() {

    private lateinit var binding: FragmentLoginSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginSuccessBinding.inflate(inflater, container, false)
        binding.viewModel = LoginSuccessViewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //取bundle資料
        //等待5秒後跳轉
        with(binding){
            txtWait.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.friendsFragment)
            }
        }
        arguments?.let { bundle ->
            bundle.getSerializable("member")?.let {
                binding.viewModel?.member?.value = it as Member
            }


        }
    }
}
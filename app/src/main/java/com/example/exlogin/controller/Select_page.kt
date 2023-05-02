package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentSelectPageBinding
import com.example.exlogin.databinding.FriendItemViewBinding
import com.example.exlogin.viewmodel.SelectPageViewModel

class Select_page : Fragment() {
    private lateinit var binding: FragmentSelectPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            button.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_select_page_to_login_page)
            }
            button2.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_select_page_to_register_page)
            }
            textView.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_select_page_to_forgot_password)

            }
        }
    }


}
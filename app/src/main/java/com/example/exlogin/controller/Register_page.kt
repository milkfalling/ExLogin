package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentRegisterPageBinding
import com.example.exlogin.model.Member
import com.example.exlogin.viewmodel.RegisterPageViewModel

class Register_page : Fragment() {

    private lateinit var binding: FragmentRegisterPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterPageBinding.inflate(inflater, container, false)
        binding.viewModel = RegisterPageViewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        這幾行想幫使用者直接拿一開始的帳密過來填
//        arguments?.let { bundle ->
//            bundle.getSerializable("member")?.let {
//                binding.viewModel?.member?.value = it as Member
//            }
            binding.viewModel?.uid?.value = "看到這行就是OKOK"
            binding.viewModel?.password?.value = "看到這行就是O了個姬芭K"
    }
}
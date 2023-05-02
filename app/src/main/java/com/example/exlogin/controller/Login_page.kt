package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentLoginPageBinding
import com.example.exlogin.model.Member
import com.example.exlogin.viewmodel.LoginPageViewModel

class Login_page : Fragment() {

    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        binding.viewModel = LoginPageViewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }
            button4.setOnClickListener {
                if (!inputValid()) {
                    return@setOnClickListener
                }
                val bundle = Bundle()
                val uid = viewModel?.uid?.value
                val password = viewModel?.password?.value
                val member = Member(uid,password)
                bundle.putSerializable("mamber",member)
                Navigation.findNavController(it)
                    .navigate(R.id.action_login_page_to_login_success, bundle)
            }
        }
    }
    private fun inputValid(): Boolean {
        var valid = true
        with(binding) {
            val uid = viewModel?.uid?.value
            val password = viewModel?.password?.value
            if (uid != null || password != null) {
                if (uid != null) {
                    if (uid.isEmpty() || uid == " ") {
                        editTextTextPersonName.error = getString(R.string.txtCantNull)
                        valid = false
                    }
                }
                if (password != null) {
                    if (password.isEmpty() || password==" ") {
                        editTextTextPersonName2.error = getString(R.string.txtCantNull)
                        valid = false
                    }
                }
            }
        }
        return valid
    }

}
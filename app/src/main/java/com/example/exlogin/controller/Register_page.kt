package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exlogin.R
import com.example.exlogin.viewmodel.RegisterPageViewModel

class Register_page : Fragment() {

    companion object {
        fun newInstance() = Register_page()
    }

    private lateinit var viewModel: RegisterPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
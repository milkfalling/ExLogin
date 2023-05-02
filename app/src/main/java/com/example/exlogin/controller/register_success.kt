package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exlogin.R
import com.example.exlogin.viewmodel.RegisterSuccessViewModel

class register_success : Fragment() {

    companion object {
        fun newInstance() = register_success()
    }

    private lateinit var viewModel: RegisterSuccessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterSuccessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
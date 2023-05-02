package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exlogin.R
import com.example.exlogin.viewmodel.ResetSuccessViewModel

class reset_success : Fragment() {

    companion object {
        fun newInstance() = reset_success()
    }

    private lateinit var viewModel: ResetSuccessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reset_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResetSuccessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
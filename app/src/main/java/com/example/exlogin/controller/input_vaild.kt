package com.example.exlogin.controller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exlogin.R
import com.example.exlogin.viewmodel.InputVaildViewModel

class input_vaild : Fragment() {

    companion object {
        fun newInstance() = input_vaild()
    }

    private lateinit var viewModel: InputVaildViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_vaild, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InputVaildViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
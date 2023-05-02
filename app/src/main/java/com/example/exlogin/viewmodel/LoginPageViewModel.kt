package com.example.exlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginPageViewModel : ViewModel() {
    val uid:MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val password:MutableLiveData<String> by lazy { MutableLiveData<String>() }
}
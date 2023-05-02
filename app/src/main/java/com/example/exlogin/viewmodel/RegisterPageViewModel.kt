package com.example.exlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exlogin.model.Member

class RegisterPageViewModel : ViewModel() {
    val uid:MutableLiveData<String> by lazy{MutableLiveData<String>()}
    val password:MutableLiveData<String> by lazy{MutableLiveData<String>()}
    val phone:MutableLiveData<String> by lazy{MutableLiveData<String>()}
    val member: MutableLiveData<Member> by lazy { MutableLiveData<Member>() }
    fun createInfo(){

    }
}
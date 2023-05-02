package com.example.exlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exlogin.model.Friend
import com.example.exlogin.model.Member
import java.io.Serializable

class LoginSuccessViewModel : ViewModel() {
    val member: MutableLiveData<Member> by lazy { MutableLiveData<Member>() }

    fun memberinfo(): String {
        val uid = member.value?.uid
        val password = member.value?.password
        val result = uid+password
        return  result
    }
}
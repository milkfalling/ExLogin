package com.example.exlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exlogin.model.Friend

class FriendViewModel : ViewModel() {
    val friend: MutableLiveData<Friend> by lazy { MutableLiveData<Friend>() }
}
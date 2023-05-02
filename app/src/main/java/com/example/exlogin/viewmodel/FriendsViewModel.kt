package com.example.exlogin.viewmodel

import com.example.exlogin.model.Friend
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exlogin.R

/**
 * 好友列表資料處理
 */
class FriendsViewModel : ViewModel() {
    // 原始好友列表，除非去遠端更新資料不然不會改變
    private var friendList = mutableListOf<Friend>()
    // 受監控的LiveData，一旦指派新值就會更新好友列表畫面
    val friends: MutableLiveData<List<Friend>> by lazy { MutableLiveData<List<Friend>>() }

    //在constuctor之後，但是在呼叫其他函式之前
    init {
        loadFriends()
    }

    /**
     * 如果搜尋條件為空字串，就顯示原始好友列表；否則就顯示搜尋後結果
     * @param newText 欲搜尋的條件字串
     */
    fun search(newText: String?) {
        if (newText == null || newText.isEmpty()) {
            friends.value = friendList
        } else {
            val searchFriendList = mutableListOf<Friend>()
            friendList.forEach { friend ->
                if (friend.name.contains(newText, true)) {
                    searchFriendList.add(friend)
                }
            }
            friends.value = searchFriendList
        }
    }

    /** 模擬取得遠端資料 */
    private fun loadFriends() {
        val friendList = mutableListOf<Friend>()
        friendList.add(Friend(R.drawable.img, "Ivy", "091234342"))
        friendList.add(Friend(R.drawable.img_1, "Mary", "090893473"))
        friendList.add(Friend(R.drawable.img_2, "Sue", "0987466644"))
        this.friendList = friendList
        this.friends.value = this.friendList
    }
}
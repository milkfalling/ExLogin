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
        friendList.add(Friend(R.drawable.img, "吉良吉影", "091234342","男","杜王町東北部","33","我的名字叫吉良吉影，33歲。住在杜王町東北部的別墅區一帶，未婚。我在龜友連鎖店服務。每天都要加班到晚上8點才能回家。我不抽煙，酒僅止於淺嚐。晚上11點睡，每天要睡足8個小時。睡前，我一定喝一杯溫牛奶，然後做20分鐘的柔軟操，上了床，馬上熟睡。一覺到天亮，決不把疲勞和壓力留到第二天。醫生都說我很正常。"))
        friendList.add(Friend(R.drawable.img_1, "野獸先輩", "090893473","男","台南","53","test"))
        friendList.add(Friend(R.drawable.img_3, "惡臭哲學家", "0987466644","男","小琉球","10","test"))
        this.friendList = friendList
        this.friends.value = this.friendList
    }
}
package com.example.exlogin.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exlogin.viewmodel.FriendsViewModel
import com.example.exlogin.databinding.FragmentFriendsBinding

class FriendsFragment : Fragment() {
    private lateinit var binding: FragmentFriendsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.hide()
        val viewModel: FriendsViewModel by viewModels()
        binding = FragmentFriendsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    //需要規範大頭貼的大小，這樣才不會跑版ㄅ
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())//這條要記得設定，不寫的話不會跳錯但東西出不來
            viewModel?.friends?.observe(viewLifecycleOwner) { friends ->
                // adapter為null要建立新的adapter；之後只要呼叫updateFriends(friends)即可
                if (recyclerView.adapter == null) {
                    recyclerView.adapter = FriendAdapter(friends)
                } else {
                    (recyclerView.adapter as FriendAdapter).updateFriends(friends)//要不要刷新要看你的列表內容是不是常常更新
                }
            }
            searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                // 輸入的文字改變時呼叫
                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel?.search(newText)
                    return true
                }
                // 點擊虛擬鍵盤上的提交鈕時呼叫
                override fun onQueryTextSubmit(text: String): Boolean {
                    return false
                }
            })
        }
    }
}
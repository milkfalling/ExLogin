package com.example.exlogin.controller

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.exlogin.viewmodel.FriendViewModel
import com.example.exlogin.databinding.FragmentFriendDetailBinding
import com.example.exlogin.model.Friend

class FriendDetailFragment : Fragment() {
    private lateinit var binding: FragmentFriendDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.show()
        val viewModel: FriendViewModel by viewModels()
        binding = FragmentFriendDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {   //判別手機版本新舊
                bundle.getSerializable("friend",Friend::class.java)?.let {
                    binding.viewModel?.friend?.value = it as Friend
                }
            } else {
                bundle.getSerializable("friend")?.let {
                    binding.viewModel?.friend?.value = it as Friend
                }
            }
        }
    }
}
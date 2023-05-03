package com.example.exlogin.controller

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.exlogin.R
import com.example.exlogin.databinding.FragmentLoginPageBinding
import com.example.exlogin.model.Member
import com.example.exlogin.viewmodel.LoginPageViewModel
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.TextView

class Login_page : Fragment() {

    private lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        binding.viewModel = LoginPageViewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()
            }
            button4.setOnClickListener {
                if (!inputValid()) {
                    return@setOnClickListener
                }
                if(!checkRegister()){
                    val message:String? = "你還沒註冊吧????????"
                    showCustomDialogBox(message)
                }


                val bundle = Bundle()
                val uid = viewModel?.uid?.value
                val password = viewModel?.password?.value
                val member = Member(uid,password)
                bundle.putSerializable("member",member)
                Navigation.findNavController(it)
                    .navigate(R.id.action_login_page_to_login_success, bundle)
            }
        }
    }

    private fun checkRegister(): Boolean {
        var isRegister = true
        with(binding){
            val uid = viewModel?.uid?.value
            val password = viewModel?.password?.value
            if(uid != "henry" ){
                isRegister = false
            }
        }
            return isRegister
    }

    @SuppressLint("ResourceType")
    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this.requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_custom_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage: TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes: Button = dialog.findViewById(R.id.btYes)
        val btnNo: Button = dialog.findViewById(R.id.btNo)

        tvMessage.text = message

        btnYes.setOnClickListener {
            //導航沒寫完
//            val bundle = Bundle()
//            val uid = binding.viewModel?.uid?.value
//            val password = binding.viewModel?.password?.value
//            val member = Member(uid,password)
//            bundle.putSerializable("member",member)
            Navigation.findNavController(it).navigate(R.id.register_page)
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun inputValid(): Boolean {
        var valid = true
        with(binding) {
            val uid = viewModel?.uid?.value
            val password = viewModel?.password?.value
            if (uid != null || password != null) {
                if (uid != null) {
                    if (uid.isEmpty() || uid == " ") {
                        editTextTextPersonName.error = getString(R.string.txtCantNull)
                        valid = false
                    }
                }
                if (password != null) {
                    if (password.isEmpty() || password==" ") {
                        editTextTextPersonName2.error = getString(R.string.txtCantNull)
                        valid = false
                    }
                }
            }
        }
        return valid
    }



}
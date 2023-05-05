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
        //資料綁定
        binding.viewModel = LoginPageViewModel()
        //生命周期綁定
        binding.lifecycleOwner = viewLifecycleOwner
        //return一個VIEW
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            //監控uid
            viewModel?.uid?.observe(viewLifecycleOwner) {
                inputValid()//進行輸入判定
            }
            //監控password
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputValid()//進行輸入判定
            }
            button4.setOnClickListener {
                if (!inputValid()) { //為了要讓檢查為不合格(false)的話執行下一段，所以要加一個!讓檢查式為true
                    return@setOnClickListener //這抄範例的，查了一下大概就是停在這啥都不做的意思，大概是讓按鈕失效的原因?
                }else if (!checkRegister()) { //若為尚未註冊帳號則
                    val message: String? = "你還沒註冊吧????????"
                    showCustomDialogBox(message)
                }else {//都通過則執行帶資料與下一頁的動作
                    val bundle = Bundle()
                    val uid = viewModel?.uid?.value
                    val password = viewModel?.password?.value
                    val member = Member(uid, password)
                    bundle.putSerializable("member", member)
                    Navigation.findNavController(it)123123
                        .navigate(R.id.friendsFragment, bundle)
                }
            }
        }
    }

    /**
     * 檢查此帳號是否為已經註冊的會員
     */
    private fun checkRegister(): Boolean {
        var isRegister = true //預設為已註冊
        with(binding) {
            val uid = viewModel?.uid?.value //擷取uid的值
            val password = viewModel?.password?.value //擷取password的值
            if (uid != "henry") { //若uid不是henry
                isRegister = false //尚未註冊指派給結果變數
            }
        }
        return isRegister //回傳結果變數
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

    /**
     * 輸入判定，預設為合格(vaild)，若uid與password不為空值
     */
    private fun inputValid(): Boolean {
        var valid = true //預設值為合格
        with(binding) {
            val uid = viewModel?.uid?.value  //擷取uid的liveData
            val password = viewModel?.password?.value //password的liveData
            if (uid == null || uid.isEmpty()) { //若為null或者空值
                etUserName.error = getString(R.string.txtCantNull) //et顯示錯誤，內容為txtCantNull
                valid = false //將不合格指派給valid
            }
            if (password == null || password.isEmpty()) { //若為null或者空值
                etPassword.error = getString(R.string.txtCantNull) //et顯示錯誤，內容為txtCantNull
                valid = false //將不合格指派給valid
            }

        }
        return valid//回傳valid
    }

}
package org.android.go.sopt.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.viewModels
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.presentation.AuthState
import org.android.go.sopt.presentation.home.HomeActivity
import org.android.go.sopt.presentation.signup.SignUpActivity
import org.android.go.sopt.util.binding.BindingActivity
import org.android.go.sopt.util.extention.hideKeyboard
import org.android.go.sopt.util.extention.showSnackbar
import org.android.go.sopt.util.extention.showToast

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@LoginActivity
        }
        addListeners()
        addObservers()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        currentFocus?.hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    private fun addListeners() {
        binding.btnToSignup.setOnClickListener {
            Intent(this, SignUpActivity::class.java).run(::startActivity)
        }
    }

    private fun addObservers() {
        viewModel.result.observe(this) {
            when (it) {
                AuthState.Empty -> binding.root.showSnackbar("아이디 또는 비밀번호를 입력해주세요")
                AuthState.Success -> {
                    this.showToast("로그인 성공!")
                    moveToHome()
                }
                AuthState.Failure -> binding.root.showSnackbar("아이디 또는 비밀번호가 달라요")
                AuthState.Error -> binding.root.showSnackbar("서버에 문제가 발생했어요")
            }
        }
    }

    // 자기소개 페이지로 이동
    private fun moveToHome() {
        Intent(this, HomeActivity::class.java).run(::startActivity)
    }
}
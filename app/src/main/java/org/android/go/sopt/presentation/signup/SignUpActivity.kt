package org.android.go.sopt.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.presentation.AuthState
import org.android.go.sopt.presentation.login.LoginActivity
import org.android.go.sopt.presentation.login.LoginViewModel
import org.android.go.sopt.util.binding.BindingActivity
import org.android.go.sopt.util.binding.ViewBindingActivity
import org.android.go.sopt.util.extention.hideKeyboard
import org.android.go.sopt.util.extention.showSnackbar
import org.android.go.sopt.util.extention.showToast

class SignUpActivity: BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel by viewModels<SignUpViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@SignUpActivity
        }
        addObservers()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        currentFocus?.hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    private fun addObservers() {
        viewModel.result.observe(this) {
            when (it) {
                AuthState.Success -> {
                    showToast("회원가입 성공!")
                    moveToLogin()
                }
                AuthState.Failure -> binding.root.showSnackbar("이름을 입력해주세요")
                AuthState.Error -> binding.root.showSnackbar("서버에 문제가 발생했어요")
                else -> binding.root.showSnackbar("몰?루")
            }
        }
    }

    // 로그인 페이지로 이동
    private fun moveToLogin() {
        Intent(this, LoginActivity::class.java)
        finish()
    }
}
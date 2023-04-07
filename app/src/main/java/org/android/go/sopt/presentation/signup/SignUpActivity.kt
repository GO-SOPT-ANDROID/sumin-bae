package org.android.go.sopt.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.presentation.login.LoginActivity
import org.android.go.sopt.util.extention.showSnackbar

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addListeners()
    }

    private fun addListeners() {
        binding.btnSignupSubmit.setOnClickListener {
            executeSignup()
        }
    }

    // 회원가입 성공 조건
    private fun isValidId(id: String): Boolean = id.length in 6..10
    private fun isValidPw(pw: String): Boolean = pw.length in 8..12

    // 회원가입 성공 여부 판단
    private fun executeSignup() {
        with(binding) {
            val inputId = etSignupId.text.toString()
            val inputPw = etSignupPw.text.toString()
            val inputName = etSignupName.text.toString()
            val inputSpecialty = etSignupSpecialty.text.toString()

            if (!isValidId(inputId)) {
                return root.showSnackbar(R.string.signup_id_fail)
            }
            if (!isValidPw(inputPw)) {
                return root.showSnackbar(R.string.signup_pw_fail)
            }

            moveToLogin(
                User(inputId, inputPw, inputName, inputSpecialty)
            )
        }
    }

    // 로그인 페이지로 이동
    private fun moveToLogin(user: User) {
        Intent(this, LoginActivity::class.java).apply {
            putExtra("info", user)
            setResult(RESULT_OK, this)
        }
        finish()
    }
}
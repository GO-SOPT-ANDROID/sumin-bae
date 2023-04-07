package org.android.go.sopt.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.presentation.profile.ProfileActivity
import org.android.go.sopt.presentation.signup.SignUpActivity
import org.android.go.sopt.util.extention.getParcelable
import org.android.go.sopt.util.extention.hideKeyboard
import org.android.go.sopt.util.extention.showSnackbar
import org.android.go.sopt.util.extention.showToast

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private var userInfo: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addListeners()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        currentFocus?.hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    private fun addListeners() {
        binding.btnLoginSubmit.setOnClickListener {
            executeLogin()
        }
        binding.btnToSignup.setOnClickListener {
            with(binding) {
                etLoginId.text.clear()
                etLoginPw.text.clear()
            }
            Intent(this, SignUpActivity::class.java).run {
                getContent.launch(this)
            }
        }
    }

    // 성공 여부에 따른 실행 동작
    private fun executeLogin() {
        with(binding) {
            val inputId = etLoginId.text.toString()
            val inputPw = etLoginPw.text.toString()

            if (inputId.isEmpty() && inputPw.isEmpty()) {
                return root.showSnackbar(R.string.login_empty)
            }
            if (!isMember(inputId, inputPw, userInfo?.id, userInfo?.pw)) {
                return root.showSnackbar(R.string.login_fail)
            }
        }
        this.showToast(R.string.login_success)
        moveToProfile()
    }

    // 로그인 성공 여부 판단
    private fun isMember(inputId: String, inputPw: String, id: String?, pw: String?): Boolean =
        inputId == id && inputPw == pw

    // 자기소개 페이지로 이동
    private fun moveToProfile() {
        Intent(this, ProfileActivity::class.java).apply {
            putExtra("info", userInfo)
            setResult(RESULT_OK, this)
            startActivity(this)
        }
    }

    // 회원가입 페이지에서 입력한 정보 가져오기
    private val getContent = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            binding.root.showSnackbar(R.string.signup_success)
            userInfo = result.data?.getParcelable("info", User::class.java)
        }
    }
}
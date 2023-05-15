package org.android.go.sopt.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.presentation.AuthState

class SignUpViewModel: ViewModel() {
    val inputId = MutableLiveData("")
    val inputPw = MutableLiveData("")
    val inputName = MutableLiveData("")
    val inputSkill = MutableLiveData("")

    // 회원가입 상태 확인용 변수
    private val _result = MutableLiveData<AuthState>()
    val result: LiveData<AuthState>
        get() = _result

    // 회원가입
    fun signup(id: String, pw: String, name: String, skill: String) {

    }
}
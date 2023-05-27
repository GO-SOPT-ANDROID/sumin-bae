package org.android.go.sopt.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.model.request.RequestSignUpDto
import org.android.go.sopt.data.model.response.ResponseSignUpDto
import org.android.go.sopt.data.service.ServicePool
import org.android.go.sopt.presentation.UiState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    val inputId = MutableLiveData("")
    val inputPw = MutableLiveData("")
    val inputName = MutableLiveData("")
    val inputSkill = MutableLiveData("")
    private val soptService = ServicePool.soptService

    // 회원가입 상태 확인용 변수
    private val _result = MutableLiveData<UiState>()
    val result: LiveData<UiState>
        get() = _result

    // 아이디, 비밀번호 유효 체크
    val isValidId = Transformations.map(inputId) { id -> checkId(id) }
    val isValidPw = Transformations.map(inputPw) { pw -> checkPw(pw) }

    private fun checkId(id: String): Boolean = id.length in 6..10
    private fun checkPw(pw: String): Boolean = pw.length in 8..12

    // 회원가입
    fun signup(id: String, pw: String, name: String, skill: String) {
        soptService.signup(
            RequestSignUpDto(id, pw, name, skill)
        ).enqueue(object : Callback<ResponseSignUpDto> {
            override fun onResponse(
                call: Call<ResponseSignUpDto>,
                response: Response<ResponseSignUpDto>,
            ) {
                // 200번대
                if (response.isSuccessful) {
                    _result.value = UiState.Success
                // 400번대 등등
                } else {
                    _result.value = UiState.Failure
                }
            }

            // 500번대
            override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                _result.value = UiState.Error
            }
        })
    }
}
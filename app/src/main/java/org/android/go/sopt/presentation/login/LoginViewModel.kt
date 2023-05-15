package org.android.go.sopt.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.model.request.RequestLoginDto
import org.android.go.sopt.data.model.response.ResponseLoginDto
import org.android.go.sopt.data.service.ServicePool
import org.android.go.sopt.presentation.UiState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    val inputId = MutableLiveData("")
    val inputPw = MutableLiveData("")
    private val authService = ServicePool.authService

    // 로그인 상태 확인용 변수
    private val _result = MutableLiveData<UiState>()
    val result: LiveData<UiState>
        get() = _result

    // 로그인
    fun login(id: String, pw: String) {
         if (id.isEmpty() || pw.isEmpty()) {
             _result.value = UiState.Empty
             return
         }
        authService.login(
            RequestLoginDto(id, pw)
        ).enqueue(object: Callback<ResponseLoginDto> {
            override fun onResponse(
                call: Call<ResponseLoginDto>,
                response: Response<ResponseLoginDto>,
            ) {
                // 200번대
                if(response.isSuccessful) {
                    _result.value = UiState.Success
                // 400번대 등등
                } else {
                    _result.value = UiState.Failure
                }
            }
            // 500번대
            override fun onFailure(call: Call<ResponseLoginDto>, t: Throwable) {
                _result.value = UiState.Error
            }
        })
    }
}
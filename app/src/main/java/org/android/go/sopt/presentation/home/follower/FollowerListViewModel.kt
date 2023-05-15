package org.android.go.sopt.presentation.home.follower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.model.response.ResponseRequesDto
import org.android.go.sopt.data.service.ServicePool
import org.android.go.sopt.presentation.UiState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerListViewModel : ViewModel() {
    private val reqresService = ServicePool.reqresService
    val followerList = mutableListOf<ResponseRequesDto.Follower>()

    private val _result = MutableLiveData<UiState>()
    val result: LiveData<UiState>
        get() = _result

    private val _list = MutableLiveData<List<ResponseRequesDto.Follower>>()
    val list: LiveData<List<ResponseRequesDto.Follower>>
        get() = _list

    fun getFollowerList() {
        reqresService.getFollowerList()
            .enqueue(object : Callback<ResponseRequesDto> {
                override fun onResponse(
                    call: Call<ResponseRequesDto>,
                    response: Response<ResponseRequesDto>,
                ) {
                    if (response.isSuccessful) {
                        _result.value = UiState.Success
                        response.body()?.let { followerList.addAll(it.data) }
                    } else {
                        _result.value = UiState.Failure
                    }
                }
                override fun onFailure(call: Call<ResponseRequesDto>, t: Throwable) {
                    _result.value = UiState.Error
                }
            })
    }
}
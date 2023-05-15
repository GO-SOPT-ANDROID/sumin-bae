package org.android.go.sopt.data.service

import org.android.go.sopt.data.model.request.RequestLoginDto
import org.android.go.sopt.data.model.response.ResponseLoginDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("sign-in")
    fun login(
        @Body request: RequestLoginDto
    ): Call<ResponseLoginDto>
}
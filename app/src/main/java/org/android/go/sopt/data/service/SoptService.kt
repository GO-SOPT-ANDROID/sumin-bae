package org.android.go.sopt.data.service

import okhttp3.MultipartBody
import org.android.go.sopt.data.model.request.RequestLoginDto
import org.android.go.sopt.data.model.request.RequestSignUpDto
import org.android.go.sopt.data.model.response.ResponseLoginDto
import org.android.go.sopt.data.model.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface SoptService {
    @POST("sign-in")
    fun login(
        @Body request: RequestLoginDto,
    ): Call<ResponseLoginDto>

    @POST("sign-up")
    fun signup(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    @Multipart
    @POST("upload")
    fun uploadImage(
        @Part file: MultipartBody.Part,
    ): Call<Unit>
}
package org.android.go.sopt.data.service

import org.android.go.sopt.data.model.response.ResponseRequesDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("/api/users?")
    fun getFollowerList(
        @Query("per_page") index: Int = 12,
    ): Call<ResponseRequesDto>
}
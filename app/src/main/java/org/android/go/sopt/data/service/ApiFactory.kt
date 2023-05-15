package org.android.go.sopt.data.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import org.android.go.sopt.BuildConfig.AUTH_BASE_URL
import okhttp3.MediaType.Companion.toMediaType
import org.android.go.sopt.BuildConfig.REQRES_BASE_URL
import retrofit2.Retrofit

object ApiFactory {
    val retrofitAuth: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AUTH_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    val retrofitReqres: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> createAuth(): T = retrofitAuth.create<T>(T::class.java)
    inline fun <reified T> createFollower(): T = retrofitReqres.create<T>(T::class.java)
}

object ServicePool {
    val authService = ApiFactory.createAuth<AuthService>()
    val reqresService = ApiFactory.createFollower<ReqresService>()
}
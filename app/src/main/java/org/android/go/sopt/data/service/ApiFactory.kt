package org.android.go.sopt.data.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.android.go.sopt.BuildConfig.REQRES_BASE_URL
import org.android.go.sopt.BuildConfig.SOPT_BASE_URL
import retrofit2.Retrofit

object ApiFactory {
    val retrofitSopt: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(SOPT_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    val retrofitReqres: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REQRES_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> createSopt(): T = retrofitSopt.create<T>(T::class.java)
    inline fun <reified T> createFollower(): T = retrofitReqres.create<T>(T::class.java)
}

object ServicePool {
    val soptService = ApiFactory.createSopt<SoptService>()
    val reqresService = ApiFactory.createFollower<ReqresService>()
}
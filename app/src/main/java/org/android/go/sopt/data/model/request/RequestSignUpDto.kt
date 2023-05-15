package org.android.go.sopt.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDto(
    val id: String,
    @SerialName("password") val pw: String,
    val name: String = "이름을 입력해주세요",
    val skill: String = "특기를 입력해주세요",
)

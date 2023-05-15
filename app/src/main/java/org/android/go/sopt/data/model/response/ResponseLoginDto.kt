package org.android.go.sopt.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseLoginDto(
    val status: Int,
    val message: String,
    val data: UserData,
) {
    @Serializable
    data class UserData(
        val id: String,
        val name: String,
        val skill: String,
    )
}
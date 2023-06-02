package org.android.go.sopt.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignUpDto(
    val status: Int,
    val message: String,
    val data: UserData,
) {
    @Serializable
    data class UserData (
        val name: String,
        val skill: String,
    )
}

package org.android.go.sopt.presentation

sealed interface AuthState {
    object Empty: AuthState
    object Success: AuthState
    object Failure: AuthState
    object Error: AuthState
}
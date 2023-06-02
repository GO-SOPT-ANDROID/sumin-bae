package org.android.go.sopt.presentation

sealed interface UiState {
    object Empty: UiState
    object Success: UiState
    object Failure: UiState
    object Error: UiState
}
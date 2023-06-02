package org.android.go.sopt.util.extention

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

// 화면 전체
fun View.showSnackbar(
    message: String,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, message, duration)
        .show()
}

// 해당 뷰 위로 올릴 때
fun View.showSnackbar(
    message: String,
    anchor: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, message, duration)
        .setAnchorView(anchor)
        .show()
}

fun View.hideKeyboard() {
    try {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    } catch (e: Exception) {
        Log.e("error", e.message.toString())
    }
}
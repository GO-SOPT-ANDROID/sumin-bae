package org.android.go.sopt.util.extention

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

// 화면 전체
fun View.showSnackbar(
    @StringRes messageId: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, messageId, duration)
        .show()
}

// 해당 뷰 위로 올릴 때
fun View.showSnackbar(
    @StringRes messageId: Int,
    anchor: Int,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    Snackbar
        .make(this, messageId, duration)
        .setAnchorView(anchor)
        .show()
}

fun View.hideKeyboard() {
    val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
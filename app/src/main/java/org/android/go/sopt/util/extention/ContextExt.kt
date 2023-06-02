package org.android.go.sopt.util.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, message, duration).show()
}
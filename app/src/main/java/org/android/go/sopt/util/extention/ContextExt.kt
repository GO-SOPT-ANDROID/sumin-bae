package org.android.go.sopt.util.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(
    @StringRes messageId: Int,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, messageId, duration).show()
}
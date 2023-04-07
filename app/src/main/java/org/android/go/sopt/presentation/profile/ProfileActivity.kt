package org.android.go.sopt.presentation.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivityProfileBinding
import org.android.go.sopt.util.extention.getParcelable

class ProfileActivity : AppCompatActivity() {
    private val binding by lazy { ActivityProfileBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = intent.getParcelable("info", User::class.java)
        constructLayout(user)
    }

    private fun constructLayout(user: User?) = with(binding) {
        tvProfileName.append(user?.name)
        tvProfileSpecialty.append(user?.specialty)
    }
}
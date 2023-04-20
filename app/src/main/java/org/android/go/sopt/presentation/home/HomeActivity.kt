package org.android.go.sopt.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityHomeBinding
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.util.binding.ViewBindingActivity

class HomeActivity : ViewBindingActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {
    private lateinit var navController: NavController
    override fun constructLayout() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)
    }
}
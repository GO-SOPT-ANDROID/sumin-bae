package org.android.go.sopt.presentation.home

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityHomeBinding
import org.android.go.sopt.presentation.home.follower.FollowerListFragment
import org.android.go.sopt.util.binding.ViewBindingActivity

class HomeActivity : ViewBindingActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {
    private lateinit var navController: NavController
    override fun constructLayout() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)

        // TODO: constructLayout() 밖으로 옮기기
        binding.bnvMain.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.follower_list_fragment -> {
                    val currentFragment = navHostFragment.childFragmentManager.fragments.first()
                    if (currentFragment is FollowerListFragment) {
                        currentFragment.scrollToTop()
                    }
                }
            }
        }
    }
}
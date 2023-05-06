package org.android.go.sopt.presentation.home.gallery

import android.os.Bundle
import android.view.View
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentGalleryBinding
import org.android.go.sopt.util.binding.ViewBindingFragment

class GalleryFragment :
    ViewBindingFragment<FragmentGalleryBinding>(FragmentGalleryBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpGallery.adapter = GalleryAdapter().apply {
            setItemList(listOf(R.drawable.arale_profile, R.drawable.ic_launcher_background))
        }
    }
}
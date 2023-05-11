package org.android.go.sopt.presentation.home.color

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import org.android.go.sopt.databinding.FragmentColorListBinding
import org.android.go.sopt.util.binding.ViewBindingFragment

class ColorListFragment :
    ViewBindingFragment<FragmentColorListBinding>(FragmentColorListBinding::inflate) {
    private val viewModel by viewModels<ColorListViewModel>()
    override fun constructLayout() {
        val colorListAdapter = ColorListAdapter(requireContext())
        colorListAdapter.submitList(viewModel.colorList)
        with(binding.rvColors) {
            adapter = colorListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    fun scrollToTop() {
        binding.rvColors.smoothScrollToPosition(0)
    }
}
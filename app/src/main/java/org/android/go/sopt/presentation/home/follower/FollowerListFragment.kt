package org.android.go.sopt.presentation.home.follower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentFollowerListBinding
import org.android.go.sopt.presentation.UiState
import org.android.go.sopt.presentation.home.HomeActivity
import org.android.go.sopt.util.binding.BindingFragment
import org.android.go.sopt.util.binding.ViewBindingFragment
import org.android.go.sopt.util.extention.showSnackbar

class FollowerListFragment :
    ViewBindingFragment<FragmentFollowerListBinding>(FragmentFollowerListBinding::inflate) {
    private val viewModel by viewModels<FollowerListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
    }

    private fun addObservers() {
        viewModel.result.observe(requireActivity()) {
            when (it) {
                UiState.Success -> {
                    initRecyclerView()
                }
                UiState.Error -> binding.root.showSnackbar("서버에 문제가 발생했어요")
                else -> binding.root.showSnackbar("몰?루")
            }
        }
    }

    private fun initRecyclerView() {
        val adapter = FollowerListAdapter(viewModel.followerList)
        binding.rvFollowers.adapter = adapter

        val gridLayoutManager = GridLayoutManager(activity, 2)
//        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//            override fun getSpanSize(position: Int): Int {
//                return when (adapter.getItemViewType(position)) {
//                    0 -> 2
//                    else -> 1
//                }
//            }
//
//        }
        binding.rvFollowers.layoutManager = gridLayoutManager
    }

    fun scrollToTop() {
        binding.rvFollowers.smoothScrollToPosition(0)
    }
}
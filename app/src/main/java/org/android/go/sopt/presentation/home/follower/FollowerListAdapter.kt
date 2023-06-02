package org.android.go.sopt.presentation.home.follower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.android.go.sopt.data.model.response.ResponseRequesDto
import org.android.go.sopt.databinding.ItemFollowerBinding

class FollowerListAdapter(private val list: List<ResponseRequesDto.Follower>) :
    ListAdapter<ResponseRequesDto.Follower, FollowerListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFollowerBinding.inflate(inflater, parent, false)
        return FollowerListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerListViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseRequesDto.Follower>() {
            override fun areItemsTheSame(
                oldItem: ResponseRequesDto.Follower,
                newItem: ResponseRequesDto.Follower,
            ): Boolean {
                return oldItem.email == newItem.email
            }

            override fun areContentsTheSame(
                oldItem: ResponseRequesDto.Follower,
                newItem: ResponseRequesDto.Follower,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class FollowerListViewHolder(
    private val binding: ItemFollowerBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: ResponseRequesDto.Follower) {
        binding.tvFollowerName.text = data.firstName
        binding.tvFollowerEmail.text = data.email
        binding.ivFollower.load(data.avatar)
    }
}
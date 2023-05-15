package org.android.go.sopt.presentation.home.follower

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.data.Color
import org.android.go.sopt.databinding.ItemColorBinding

class ColorListAdapter(context: Context) : ListAdapter<Color, ColorListViewHolder>(diffUtil) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorListViewHolder {
        val binding = ItemColorBinding.inflate(inflater, parent, false)
        return ColorListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorListViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Color>() {
            override fun areItemsTheSame(oldItem: Color, newItem: Color): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Color, newItem: Color): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class ColorListViewHolder(
    private val binding: ItemColorBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(colorData: Color) {
        with(binding) {
            ivColor.setBackgroundColor(android.graphics.Color.parseColor(colorData.hex))
            tvColorName.text = colorData.name
            tvColorHex.text = colorData.hex
        }
    }
}
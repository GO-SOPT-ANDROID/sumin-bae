package org.android.go.sopt.presentation.home.color

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemColorHeaderBinding

class ColorHeaderAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemColorHeaderBinding.inflate(inflater, parent, false)
        return ColorHeaderViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
}

class ColorHeaderViewHolder(
    private val binding: ItemColorHeaderBinding,
) : RecyclerView.ViewHolder(binding.root) {}
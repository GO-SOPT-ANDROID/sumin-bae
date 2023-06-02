package org.android.go.sopt.presentation.home.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemGalleryBinding

class GalleryAdapter(
    _itemList: List<Int> = listOf()
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    private var itemList: List<Int> = _itemList

    class GalleryViewHolder(
        private val binding: ItemGalleryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(src: Int) {
            binding.imgGallery.setImageResource(src)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    fun setItemList(itemList: List<Int>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}
package com.jun_zheng.imageeditor.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jun_zheng.imageeditor.databinding.GridViewItemBinding
import com.jun_zheng.imageeditor.network.ImageProperty

class PhotoGridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ImageProperty, PhotoGridAdapter.ImagePropertyViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ImageProperty>() {
        override fun areItemsTheSame(oldItem: ImageProperty, newItem: ImageProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ImageProperty, newItem: ImageProperty): Boolean {
            return oldItem.url == newItem.url
        }

    }

    class ImagePropertyViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageProperty: ImageProperty) {
            binding.property = imageProperty
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (imageProperty: ImageProperty) -> Unit) {
        fun onClick(imageProperty: ImageProperty) = clickListener(imageProperty)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImagePropertyViewHolder {
        return ImagePropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImagePropertyViewHolder, position: Int) {
        val imageProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick((imageProperty))
        }
        holder.bind(imageProperty)
    }
}
package com.sapar.orderapplication.presentation.adapters

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.ItemCategoryBinding
import com.sapar.orderapplication.domain.entities.Category

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) {
        binding.name.text = category.name
    }

    fun defaultCardStroke(ownBinding: ItemCategoryBinding = binding) {
        ownBinding.name.setTextColor(
            ContextCompat.getColor(
                binding.root.context,
                R.color.graySecond
            )
        )
        ownBinding.root.setCardBackgroundColor(Color.WHITE)
    }

    fun selectedCardStroke() {
        binding.root.setCardBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                R.color.gray
            )
        )
    }
}
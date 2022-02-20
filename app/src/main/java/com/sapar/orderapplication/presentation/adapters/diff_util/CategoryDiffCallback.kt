package com.sapar.orderapplication.presentation.adapters.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.sapar.orderapplication.domain.entities.Category

class CategoryDiffCallback :DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}

package com.sapar.orderapplication.presentation.adapters.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.sapar.orderapplication.domain.entities.Product

class ProductDiffCallback: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}

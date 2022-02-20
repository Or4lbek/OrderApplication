package com.sapar.orderapplication.presentation.adapters.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.sapar.orderapplication.domain.entities.Order

class OrderDiffCallback: DiffUtil.ItemCallback<Order>() {
    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }
}

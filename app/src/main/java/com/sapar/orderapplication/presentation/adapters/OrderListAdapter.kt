package com.sapar.orderapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sapar.orderapplication.databinding.ItemMyOrdersBinding
import com.sapar.orderapplication.domain.entities.Order
import com.sapar.orderapplication.presentation.adapters.diff_util.OrderDiffCallback


class OrderListAdapter : ListAdapter<Order, OrderViewHolder>(OrderDiffCallback()) {

    var clickListener: ((Order) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding: ItemMyOrdersBinding = ItemMyOrdersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { clickListener?.invoke(item) }
        holder.bind(item)
    }

}
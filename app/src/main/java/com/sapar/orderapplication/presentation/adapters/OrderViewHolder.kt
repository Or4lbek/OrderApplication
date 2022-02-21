package com.sapar.orderapplication.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.databinding.ItemMyOrdersBinding
import com.sapar.orderapplication.domain.entities.Order


class OrderViewHolder(
    val binding: ItemMyOrdersBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Order) = with(binding) {
        textViewMyOrdersName.text = item.restaurantName
        textViewMyOrdersStatus.text = item.status.string
        textViewMyOrdersDate.text = item.orderDate.toString()
        textViewMyOrdersPrice.text = item.totalPrice.toString()
    }
}
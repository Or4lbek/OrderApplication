package com.sapar.orderapplication.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.databinding.ItemParentMenuBinding
import com.sapar.orderapplication.domain.entities.Category

class ParentViewHolder(private val binding: ItemParentMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        with(binding) {
            category.text = item.name
            val adapter = ChildMenuAdapter()
            mealRv.adapter = adapter
            adapter.submitList(item.productList)
        }
    }
}
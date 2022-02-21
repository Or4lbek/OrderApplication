package com.sapar.orderapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sapar.orderapplication.databinding.ItemMenuBinding
import com.sapar.orderapplication.domain.entities.Product
import com.sapar.orderapplication.presentation.adapters.diff_util.ProductDiffCallback

class ChildMenuAdapter: ListAdapter<Product, ChildViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding =
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
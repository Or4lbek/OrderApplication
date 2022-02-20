package com.sapar.orderapplication.presentation.adapters

import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.ItemMenuBinding
import com.sapar.orderapplication.domain.entities.Product
import com.squareup.picasso.Picasso

class ProductViewHolder(private val binding: ItemMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        binding.minusBtn.setOnClickListener {
            if (binding.counts.text.toString().toInt() > 0) {
                binding.counts.text = binding.counts.text.toString().toInt().minus(1).toString()
            }
        }
        binding.plusBtn.setOnClickListener {
            binding.counts.text = binding.counts.text.toString().toInt().plus(1).toString()
        }
        binding.counts.addTextChangedListener {
            items[absoluteAdapterPosition].counter = binding.counts.text.toString().toInt()
            listener.onChangeCount(
                items[absoluteAdapterPosition]
            )
        }
    }

    fun bind(item: Product) {
        binding.name.text = item.name
        binding.price.text = item.getPriceAsString()
        Picasso.get().load(item.imageUrl).placeholder(R.drawable.back)
            .error(R.drawable.back).into(binding.imageViewMenuMealImage)
    }
}
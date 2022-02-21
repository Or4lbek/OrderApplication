package com.sapar.orderapplication.presentation.adapters

import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.ItemMenuBinding
import com.sapar.orderapplication.domain.entities.Product
import com.squareup.picasso.Picasso

class ChildViewHolder(private val binding: ItemMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product) {

        binding.minusBtn.setOnClickListener {
            if (binding.counts.text.toString().toInt() > 0) {
                binding.counts.text = binding.counts.text.toString().toInt().minus(1).toString()
                item.count--
                updateCount(item.count)
            }
        }

        binding.plusBtn.setOnClickListener {
            binding.counts.text = binding.counts.text.toString().toInt().plus(1).toString()
            item.count++
            updateCount(item.count)
        }

        binding.counts.text = item.count.toString()
        binding.name.text = item.name
        binding.price.text = item.price.toString()
        Picasso.get().load(item.image).placeholder(R.drawable.back)
            .error(R.drawable.back).into(binding.imageViewMenuMealImage)
    }

    private fun updateCount(count: Int){
        binding.counts.text = count.toString()
    }
}
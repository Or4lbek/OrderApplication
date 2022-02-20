package com.sapar.orderapplication.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.data.menu.Meal
import com.sapar.orderapplication.databinding.ItemMenuBinding
import com.sapar.orderapplication.domain.entities.Product
import com.sapar.orderapplication.presentation.adapters.diff_util.ProductDiffCallback
import com.squareup.picasso.Picasso

class ChildMenuAdapter(
    val listener: ChildMenuAdapterListener
) : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {


    var items: List<Product> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class CategoryContainerViewHolder(private val binding: ItemMenuBinding) :
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
            binding.counts.text = item.counter.toString()
            binding.name.text = item.name
            binding.price.text = item.getPriceAsString()
            Picasso.get().load(item.imageUrl).placeholder(R.drawable.back)
                .error(R.drawable.back).into(binding.imageViewMenuMealImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface ChildMenuAdapterListener {
        fun onChangeCount(meal: Meal)
    }

}
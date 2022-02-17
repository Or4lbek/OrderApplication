package com.sapar.orderapplication.present.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.common.MarginItemDecoration
import com.sapar.orderapplication.data.menu.CategoryMeal
import com.sapar.orderapplication.databinding.ItemParentMenuBinding

class ParentMenuAdapter(private val listener: ChildMenuAdapter.ChildMenuAdapterListener) :
    RecyclerView.Adapter<ParentMenuAdapter.CategoryContainerViewHolder>() {

    var items: List<CategoryMeal> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class CategoryContainerViewHolder(private val binding: ItemParentMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.mealRv.addItemDecoration(
                MarginItemDecoration(
                    binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    20
                )
            )
        }

        fun bind(item: CategoryMeal) {
            binding.category.text = item.category
            binding.mealRv.isNestedScrollingEnabled = false
            binding.mealRv.adapter = ChildMenuAdapter(listener).apply {
                items = item.meals
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemParentMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
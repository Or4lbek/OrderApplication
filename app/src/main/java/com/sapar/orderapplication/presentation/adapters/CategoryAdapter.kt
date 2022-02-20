package com.sapar.orderapplication.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sapar.orderapplication.databinding.ItemCategoryBinding
import com.sapar.orderapplication.domain.entities.Category
import com.sapar.orderapplication.presentation.adapters.diff_util.CategoryDiffCallback

class CategoryAdapter() : ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()) {

    var onClickCategory: ((Int) -> Unit)? = null // TODO

    private var selectedItemPos = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { onClickCategory?.invoke(position) }

        if (item.isCurrent) {
            holder.selectedCardStroke()
        } else
            holder.defaultCardStroke()
        holder.bind(item)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            when (payloads[0]) {
                2 -> {
                    getItem(position).isCurrent = false
                }
            }
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun selectItem(pos: Int) {
        if (selectedItemPos != -1)
            getItem(selectedItemPos).isCurrent = false
        getItem(selectedItemPos).isCurrent = true
        selectedItemPos = pos
        notifyDataSetChanged()
    }
}
package com.sapar.orderapplication.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.databinding.ItemParentMenuBinding
import com.sapar.orderapplication.domain.entities.Category
import com.sapar.orderapplication.presentation.adapters.diff_util.CategoryDiffCallback
import com.sapar.orderapplication.utils.MarginItemDecoration

class ParentMenuAdapter() : ListAdapter<Category, ParentViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val binding =
            ItemParentMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
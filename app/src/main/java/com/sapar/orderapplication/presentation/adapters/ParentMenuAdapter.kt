package com.sapar.orderapplication.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.databinding.ItemParentMenuBinding
import com.sapar.orderapplication.domain.entities.Category
import com.sapar.orderapplication.utils.MarginItemDecoration

class ParentMenuAdapter() :
    RecyclerView.Adapter<ParentMenuAdapter.CategoryContainerViewHolder>() {

    inner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemParentMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {

        holder.bind()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
package com.sapar.orderapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sapar.orderapplication.databinding.ItemEstablishmentRecordBinding
import com.sapar.orderapplication.domain.entities.RestaurantDetails
import com.sapar.orderapplication.presentation.adapters.diff_util.RestaurantDiffCallback

class RestaurantListAdapter() : ListAdapter<RestaurantDetails, RestaurantViewHolder>(
    RestaurantDiffCallback()
) {

    var clickListener: ((item: RestaurantDetails) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemEstablishmentRecordBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { clickListener?.invoke(item) }
        holder.bind(item)
    }

}
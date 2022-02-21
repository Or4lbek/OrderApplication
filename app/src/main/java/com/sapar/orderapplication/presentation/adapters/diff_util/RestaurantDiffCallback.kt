package com.sapar.orderapplication.presentation.adapters.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.sapar.orderapplication.domain.entities.RestaurantDetails

class RestaurantDiffCallback: DiffUtil.ItemCallback<RestaurantDetails>() {
    override fun areItemsTheSame(oldItem: RestaurantDetails, newItem: RestaurantDetails): Boolean {
        return oldItem.info.id == newItem.info.id
    }

    override fun areContentsTheSame(
        oldItem: RestaurantDetails,
        newItem: RestaurantDetails
    ): Boolean {
        return oldItem == newItem
    }

}

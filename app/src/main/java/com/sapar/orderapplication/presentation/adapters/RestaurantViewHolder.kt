package com.sapar.orderapplication.presentation.adapters

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.ItemEstablishmentRecordBinding
import com.sapar.orderapplication.domain.entities.RestaurantDetails
import com.squareup.picasso.Picasso

class RestaurantViewHolder(
    private val binding: ItemEstablishmentRecordBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RestaurantDetails) = with(binding) {
        textViewEstablishmentName.text = item.info.name
        textViewEstablishmentAddress.text = item.info.location
        Picasso.get().load(item.info.imageList[0]).placeholder(R.drawable.back)
            .error(R.drawable.back).into(imageViewEstablishmentIcon)
        itemView.startAnimation(
            AnimationUtils.loadAnimation(
                root.context,
                R.anim.recycler_view_animation
            )
        )
    }
}
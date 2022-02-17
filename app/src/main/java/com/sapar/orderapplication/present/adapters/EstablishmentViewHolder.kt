package com.sapar.orderapplication.present.adapters

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.sapar.orderapplication.R
import com.sapar.orderapplication.data.establishment.EstablishmentsItem
import com.sapar.orderapplication.databinding.ItemEstablishmentRecordBinding
import com.squareup.picasso.Picasso

class EstablishmentViewHolder(
    private val binding: ItemEstablishmentRecordBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EstablishmentsItem) = with(binding) {
        textViewEstablishmentName.text = item.name
        textViewEstablishmentAddress.text = item.address
        Picasso.get().load(item.imageUrl).placeholder(R.drawable.back)
            .error(R.drawable.back).into(imageViewEstablishmentIcon)
        itemView.startAnimation(
            AnimationUtils.loadAnimation(
                root.context,
                R.anim.recycler_view_animation
            )
        )
    }
}
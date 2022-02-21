package com.sapar.orderapplication.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantInfo(
   val id: Int,
   val name: String,
   val location: String,
   val imageList: List<String>
) : Parcelable
package com.sapar.orderapplication.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// TODO
@Parcelize
data class RestaurantDetails(
    val info: RestaurantInfo,
    val categoryList: List<Category>
) : Parcelable
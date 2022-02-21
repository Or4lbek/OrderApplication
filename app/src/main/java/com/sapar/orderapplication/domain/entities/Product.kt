package com.sapar.orderapplication.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val image: String,
    var count: Int = NOT_IN_CART
): Parcelable{
    companion object{
        const val NOT_IN_CART = 0
    }
}
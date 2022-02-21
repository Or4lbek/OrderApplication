package com.sapar.orderapplication.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String,
    val productList: List<Product>,
    val productCount: Int = 0,
    var isCurrent: Boolean = false
) : Parcelable
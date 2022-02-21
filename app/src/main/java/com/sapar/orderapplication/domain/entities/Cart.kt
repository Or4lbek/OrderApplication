package com.sapar.orderapplication.domain.entities

data class Cart(
    val restaurantName: String,
    val location: String,
    val cartProductList: ArrayList<CartProduct>,
    var totalPrice: Int // TODO как то подсчитать
)
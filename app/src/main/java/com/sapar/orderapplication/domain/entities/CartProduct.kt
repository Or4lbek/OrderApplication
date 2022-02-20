package com.sapar.orderapplication.domain.entities

data class CartProduct(
    val productId: Int,
    val name: String,
    val price: Int,
    var count: Int,
)
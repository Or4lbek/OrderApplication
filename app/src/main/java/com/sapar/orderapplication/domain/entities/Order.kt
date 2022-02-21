package com.sapar.orderapplication.domain.entities

import java.util.*

data class Order(
    val id: Int, // номер заказа
    val restaurantName: String,
    val restaurantAddress: String,
    val status: OrderStatus,
    val totalPrice: Int,
    val orderDate: Date,
    val productList: List<Product>
)

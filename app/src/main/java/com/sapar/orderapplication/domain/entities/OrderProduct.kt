package com.sapar.orderapplication.domain.entities

data class OrderProduct(
    val id: Int,
    val name: String,
    val pricePerUnit: Int,
    val count: Int,
)

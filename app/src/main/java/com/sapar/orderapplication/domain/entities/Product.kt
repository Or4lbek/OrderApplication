package com.sapar.orderapplication.domain.entities

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val image: String
)
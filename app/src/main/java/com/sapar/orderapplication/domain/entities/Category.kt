package com.sapar.orderapplication.domain.entities

data class Category(
    val id: Int,
    val name: String,
    val productCount: Int,
    var isCurrent: Boolean,
    val productList: List<Product>
)
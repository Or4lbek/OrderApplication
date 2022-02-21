package com.sapar.orderapplication.domain.entities

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val image: String,
    var count: Int = NOT_IN_CART
){
    companion object{
        const val NOT_IN_CART = 0
    }
}
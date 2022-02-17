package com.sapar.orderapplication.data.menu

data class Meal(
    val id: String,
    val name: String,
    val imageUrl: String,
    var price: Int,
    var counter: Int = 0,
    val description: String
) {
    fun getPriceAsString(): String {
        return "$price тг"
    }
}

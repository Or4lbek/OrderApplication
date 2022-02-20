package com.sapar.orderapplication.domain.entities

data class RestaurantDetails(
    val info: RestaurantInfo,
    val categoryList: List<Category>
)
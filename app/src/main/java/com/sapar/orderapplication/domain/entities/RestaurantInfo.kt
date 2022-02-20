package com.sapar.orderapplication.domain.entities

data class RestaurantInfo(
   val id: Int,
   val name: String,
   val location: String,
   val imageList: List<String>
)
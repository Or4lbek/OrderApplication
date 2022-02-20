package com.sapar.orderapplication.domain.repository

import com.sapar.orderapplication.domain.entities.Category
import com.sapar.orderapplication.domain.entities.RestaurantDetails
import com.sapar.orderapplication.domain.entities.RestaurantInfo

interface RestaurantRepository {

    // callOnHomeFragment
    fun getRestaurantList(): List<RestaurantInfo>

    // callOnRestaurantCardClick
    fun getRestaurant(restaurantId: Int): RestaurantDetails

    // callOnBurgerMenuClick
    fun getCategories(restaurantId: Int): List<Category>

}
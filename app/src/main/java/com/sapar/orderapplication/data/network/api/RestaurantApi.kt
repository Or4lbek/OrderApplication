package com.sapar.orderapplication.data.network.api

import com.sapar.orderapplication.data.network.dto.CategoryDto
import com.sapar.orderapplication.data.network.dto.RestaurantDto
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {

    // TODO
    @GET
    suspend fun getRestaurantList(): Response<List<RestaurantDto>>

    @GET
    suspend fun getRestaurant(restaurantId: Int): Response<RestaurantDto>

    @GET
    suspend fun getCategories(): Response<List<CategoryDto>>
}
package com.sapar.orderapplication.data.network.api

import com.sapar.orderapplication.data.network.dto.OrderDto
import com.sapar.orderapplication.data.network.request.CreateOrderRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderApi {



    @GET
    suspend fun getOrderList(): List<OrderDto>

    @GET
    suspend fun getOrder(orderId: Int): Response<OrderDto>

    @POST
    suspend fun createOrder(@Body createOrderRequest: CreateOrderRequest) : Response<Boolean> // TODO
}
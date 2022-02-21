package com.sapar.orderapplication.domain.repository

import com.sapar.orderapplication.domain.entities.Order

interface OrderRepository {

    // callOnOrderListFragmentShow
    fun getOrderList(): List<Order>

    // callOnOrderCardClick
    fun getOrder(orderId: Int): Order

}
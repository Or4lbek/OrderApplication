package com.sapar.orderapplication.domain.repository

import com.sapar.orderapplication.domain.entities.Cart

interface CartRepository {

    // callOnAddButtonClick
    fun addToCart(productId:Int)

    // callOnRemoveButtonClick
    // when count = 0, delete from cart
    fun removeFromCart(productId: Int)

    // callOnPayButtonClick
    fun createOrder(cart: Cart)
}
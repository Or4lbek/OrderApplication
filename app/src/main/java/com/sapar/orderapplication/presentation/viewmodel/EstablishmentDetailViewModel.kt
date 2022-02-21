package com.sapar.orderapplication.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sapar.orderapplication.common.Constants
import com.sapar.orderapplication.domain.entities.Category
import com.sapar.orderapplication.domain.entities.Product

class EstablishmentDetailViewModel : ViewModel() {
    val liveData: MutableLiveData<List<Category>> = MutableLiveData()

    init {
        fetchAllCategories()
    }

    var totalPrice = 0

    private fun fetchAllCategories() {
        val meal1 = Product(
            id = 1,
            name = "Маргаритта",
            image = Constants.PIZZA_URL,
            price = 1700,
            description = "23456"
        )
        val meal2 = Product(
            id = 2,
            name = "Маргаритта",
            image = Constants.PIZZA_URL,
            price = 1700,
            description = "23456"
        )
        val meal3 = Product(
            id = 3,
            name = "Маргаритта3",
            image = Constants.PIZZA_URL,
            price = 1800,
            description = "23456"
        )
        val categoryPizza = Category(
            1,
            name = "Пицца",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            ),
        )
        val categoryDrinks = Category(
            2,
            name = "Напитки",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits = Category(
            3,
            name = "Фрукты",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits1 = Category(
            3,
            name = "Фрукты1",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits12 = Category(
            3,
            name = "Фрукты12",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits13 = Category(
            3,
            name = "Фрукты13",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits14 = Category(
            3,
            name = "Фрукты14",
            productList = listOf(
                meal1,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3,
                meal2,
                meal3
            )
        )
        val categoryFruits15 = Category(
            3,
            name = "Фрукты15",
            productList = listOf(
                meal1
            )
        )

        liveData.postValue(
            listOf(
                categoryPizza,
                categoryFruits,
                categoryDrinks,
                categoryFruits1,
                categoryFruits12,
                categoryFruits13,
                categoryFruits14,
                categoryFruits15
            )
        )
    }
}
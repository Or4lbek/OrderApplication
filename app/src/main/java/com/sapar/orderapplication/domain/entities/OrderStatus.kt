package com.sapar.orderapplication.domain.entities

enum class OrderStatus(val string: String) {
    IN_PROGRESS("В обработке"),
    COOKING("На кухне"),
    READY("Готов"),
    DONE("Завершен"),
}

package com.example.kata.leansupermarket

class CheckoutManager(private val calculator: CheckoutCalculator = CheckoutCalculator.aNew()) {
    fun ring(nextLine: String): CheckoutManager {
        val product = nextLine
        if (product.contains(",")) {
            product.split(",").forEach { calculator.ring(it.trim()) }
        } else {
            calculator.ring(product)
        }
        return this
    }

    fun total(): Int {
        return calculator.total()
    }

}

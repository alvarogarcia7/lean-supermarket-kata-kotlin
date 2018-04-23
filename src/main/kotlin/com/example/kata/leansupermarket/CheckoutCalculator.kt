package com.example.kata.leansupermarket

class CheckoutCalculator {
    private val products = mutableListOf<String>()
    fun ring(product: String): CheckoutCalculator {
        products.add(product)
        return this
    }

    fun total(): Int {
        var total = 0
        for (product in products) {
            total += if (product == "Apples") {
                100
            } else {
                75
            }
        }
        if (products.filter { it == "Cherries" }.count() == 2) {
            total -= 20
        }
        return total
    }

}

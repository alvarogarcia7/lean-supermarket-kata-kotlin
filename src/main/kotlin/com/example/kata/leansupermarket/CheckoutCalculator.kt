package com.example.kata.leansupermarket

import java.io.PrintStream

class CheckoutCalculator(val out: PrintStream) {
    private val products = mutableListOf<String>()
    fun ring(product: String): CheckoutCalculator {
        this.products.add(product)
        out.println(this.total())
        return this
    }

    fun total(): Int {
        var total = 0
        for (product in products) {
            total += if (product == "Apples") {
                100
            } else if (product == "Cherries") {
                75
            } else if (product == "Bananas") {
                150
            } else {
                0
            }
        }
        if (products.filter { it == "Cherries" }.count() == 2) {
            total -= 30
        }
        return total
    }

}

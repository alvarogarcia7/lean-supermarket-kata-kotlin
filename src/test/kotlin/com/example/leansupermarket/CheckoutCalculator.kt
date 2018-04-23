package com.example.leansupermarket

class CheckoutCalculator {
    var total = 0
    fun ring(product: String): CheckoutCalculator {
        if (product == "Apples") {
            total += 100
        } else {
            total += 75
        }
        return this
    }

    fun total(): Int {
        return total
    }

}

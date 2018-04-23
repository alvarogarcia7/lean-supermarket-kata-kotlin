package com.example.leansupermarket

class CheckoutCalculator {
    var total = 0
    fun ring(product: String): CheckoutCalculator {
        total += 100
        return this
    }

    fun total(): Int {
        return total
    }

}

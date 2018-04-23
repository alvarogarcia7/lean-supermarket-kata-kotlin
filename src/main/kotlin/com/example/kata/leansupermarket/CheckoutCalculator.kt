package com.example.kata.leansupermarket

import java.io.PrintStream

class CheckoutCalculator(val out: PrintStream, val r1: (Int, List<String>) -> Int) {
    private val products = mutableListOf<String>()
    fun ring(product: String): CheckoutCalculator {
        this.products.add(product)
        out.println(this.total())
        return this
    }

    fun total(): Int {
        var total = 0
        for (product in products) {
            total += if (isApple(product)) {
                100
            } else if (product == "Cherries") {
                75
            } else if (product == "Bananas") {
                150
            } else {
                0
            }
        }
        total = r1(total, this.products)
        if (products.filter { it == "Bananas" }.count() == 2) {
            total -= 150
        }
        return total
    }


    private fun isApple(product: String) = product == "Apples" || product == "Mele" || product == "Pommes"


    companion object {
        fun aNew(): CheckoutCalculator {
            fun r1(total: Int, products: List<String>): Int {
                var result = total
                if (products.filter { it == "Cherries" }.count() == 2) {
                    result -= 20
                }
                return result
            }
            return CheckoutCalculator(System.out, ::r1)
        }
    }
}

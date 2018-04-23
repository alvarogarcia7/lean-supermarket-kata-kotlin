package com.example.kata.leansupermarket

import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    checkout(reader)
}

private fun checkout(reader: Scanner) {
    val calculator = CheckoutCalculator()
    while (true) {
        val nextLine = reader.nextLine()
        if (nextLine.isEmpty()) {
            break
        }
        calculator.ring(nextLine)
        println(calculator.total())
    }
}
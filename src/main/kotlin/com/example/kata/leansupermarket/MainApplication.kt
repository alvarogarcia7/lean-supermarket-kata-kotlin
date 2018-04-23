package com.example.kata.leansupermarket

import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    var lines = mutableListOf<String>()
    while (true) {
        val nextLine = reader.nextLine()
        if (nextLine.isEmpty()) {
            break
        } else {
            lines.add(nextLine)
        }
    }
    checkout(lines)
}

private fun checkout(lines: List<String>) {
    val calculator = CheckoutCalculator()
    lines.forEach { calculator.ring(it) }
    println(calculator.total)
}
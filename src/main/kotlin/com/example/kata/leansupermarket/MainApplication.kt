package com.example.kata.leansupermarket

import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    Orchestrator(reader).checkout()
}

class Orchestrator(val reader: Scanner) {
    fun checkout() {
        val manager = CheckoutManager()
        while (true) {
            val nextLine = reader.nextLine()
            if (nextLine.isEmpty()) {
                break
            }
            manager.ring(nextLine)
        }
    }
}

package com.example.leansupermarket

import com.example.kata.leansupermarket.main
import org.junit.jupiter.api.Test

class MainApplicationTest {
    @Test
    fun `make use of the main application`() {
        main(arrayOf("0", "1,", "2"))
    }
}
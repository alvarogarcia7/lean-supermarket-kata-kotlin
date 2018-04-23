package com.example.leansupermarket

import com.example.kata.leansupermarket.main
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainApplicationTest {
    @Test
    fun `make use of the main application`() {
        main(arrayOf("0", "1,", "2"))
    }

    @Test
    fun `test apples`() {
        assertThat(CheckoutCalculator().ring("Apples").total()).isEqualTo(100)
    }

    @Test
    fun `Iteration 0 - Acceptance test`() {
        assertThat(CheckoutCalculator()
                .ring("Apples")
                .ring("Cherries")
                .ring("Cherries")
                .total()).isEqualTo(250)
    }

}
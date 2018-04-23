package com.example.leansupermarket

import com.example.kata.leansupermarket.CheckoutCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainApplicationTest {
    @Test
    fun `test apples`() {
        assertThat(CheckoutCalculator().ring("Apples").total()).isEqualTo(100)
    }

    @Test
    fun `Iteration 2 - Acceptance test with discount`() {
        assertThat(CheckoutCalculator()
                .ring("Apples")
                .ring("Cherries")
                .ring("Cherries")
                .total()).isEqualTo(250 - 20)
    }

    @Test
    fun `Iteration 1 - Acceptance test`() {
        assertThat(CheckoutCalculator()
                .ring("Apples")
                .ring("Cherries")
                .total()).isEqualTo(100 + 75)
    }

    @Test
    fun `Iteration 3 - Acceptance test - separate products by commas`() {
        assertThat(CheckoutCalculator()
                .ring("Apples, Cherries, Bananas")
                .total()).isEqualTo(325)
    }

}
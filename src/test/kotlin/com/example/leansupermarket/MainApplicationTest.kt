package com.example.leansupermarket

import com.example.kata.leansupermarket.CheckoutManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainApplicationTest {
    @Test
    fun `test apples`() {
        assertThat(CheckoutManager().ring("Apples").total()).isEqualTo(100)
    }

    @Test
    fun `Iteration 2 - Acceptance test with discount`() {
        assertThat(CheckoutManager()
                .ring("Apples")
                .ring("Cherries")
                .ring("Cherries")
                .total()).isEqualTo(250 - 20)
    }

    @Test
    fun `Iteration 3a - Acceptance test with discount`() {
        assertThat(CheckoutManager()
                .ring("Cherries")
                .ring("Cherries")
                .total()).isEqualTo(75 + 75 - 20)
    }

    @Test
    fun `Iteration 3a - Bananas buy one get one free`() {
        assertThat(CheckoutManager()
                .ring("Bananas")
                .ring("Bananas")
                .total()).isEqualTo(150 + 150 - 150)
    }

    @Test
    fun `Iteration 3a - Support internationalization for apples`() {
        assertThat(CheckoutManager()
                .ring("Apples")
                .ring("Pommes")
                .ring("Mele")
                .total()).isEqualTo(3 * 100)
    }

    @Test
    fun `Iteration 1 - Acceptance test`() {
        assertThat(CheckoutManager()
                .ring("Apples")
                .ring("Cherries")
                .total()).isEqualTo(100 + 75)
    }

    @Test
    fun `Iteration 3 - Acceptance test - separate products by commas`() {
        assertThat(CheckoutManager()
                .ring("Apples, Cherries, Bananas")
                .total()).isEqualTo(325)
    }

}
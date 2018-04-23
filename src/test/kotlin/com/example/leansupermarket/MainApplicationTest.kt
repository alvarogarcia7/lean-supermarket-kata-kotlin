package com.example.leansupermarket

import com.example.kata.leansupermarket.CheckoutManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainApplicationTest {
    private val CHERRIES_DISCOUNT = 20

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
                .total()).isEqualTo(250 - CHERRIES_DISCOUNT)
    }

    @Test
    fun `Iteration 3a - Acceptance test with discount`() {
        assertThat(CheckoutManager()
                .ring("Cherries")
                .ring("Cherries")
                .total()).isEqualTo(75 + 75 - CHERRIES_DISCOUNT)
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
    fun `Iteration 5 - Support multiple discounts`() {
        assertThat(CheckoutManager()
                .ring("Mele").equalTo(100)
                .ring("Pommes").equalTo(200)
                .ring("Pommes").equalTo(300)
                .ring("Apples").equalTo(400)
                .ring("Pommes").equalTo(400)
                .ring("Mele").equalTo(400)
                .ring("Cherries").equalTo(475)
                .ring("Cherries").equalTo(530)
                .total()).isEqualTo(530)
    }

    @Test
    fun `Iteration 5a - Support multiple discounts in CSV format`() {
        assertThat(CheckoutManager()
                .ring("Mele, Pommes, Pommes, Apples, Pommes, Mele, Cherries, Cherries, Bananas").equalTo(680)
                .total()).isEqualTo(680)
    }

    @Test
    fun `Multiple promotions apply`() {
        assertThat(CheckoutManager()
                .ring("Cherries, Cherries")
                .ring("Bananas, Bananas")
                .total()).isEqualTo(75 * 2 - CHERRIES_DISCOUNT + 150 * 2 - 150)
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

private fun CheckoutManager.equalTo(i: Int): CheckoutManager {
    assertThat(this.total()).isEqualTo(i)
    return this
}

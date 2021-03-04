package com.github.elvirka.tasks.educative

import com.github.elvirka.tasks.educative.kotlinCourse.tryTests.Airport
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify

class AirportTest : StringSpec() {

    private val iah = Airport("IAH", "Houston", true)
    private val iad = Airport("IAD", "Dulles", false)
    private val ord = Airport("ORD", "Chicago O'Hare", true)

    override fun beforeTest(testCase: TestCase) =
        mockkObject(Airport)

    override fun afterTest(testCase: TestCase, result: TestResult) =
        clearAllMocks()

    init {
        "create Airport" {
            iah.code shouldBe "IAH"
            iad.name shouldBe "Dulles"
            ord.delay shouldBe true
          }
        "sort empty list should return an empty list" {
            Airport.sort(listOf()) shouldBe listOf()
        }
        "sort list with one Airport should return the given Airport" {
            Airport.sort(listOf(iad)) shouldBe listOf(iad)
        }
        "sort pre-sorted list should return the given list" {
            Airport.sort(listOf(iad, iah)) shouldBe listOf(iad, iah)
        }
        "sort airports should return airports in sorted order of name" {
            Airport.sort(listOf(iah, iad, ord)) shouldBe listOf(ord, iad, iah)
        }

        "sort airports by name" {
            forall(
                row(listOf(), listOf()),
                row(listOf(iad), listOf(iad)),
                row(listOf(iad, iah), listOf(iad, iah)),
                row(listOf(iad, iah, ord), listOf(ord, iad, iah))
            )
            { input, result -> Airport.sort(input) shouldBe result }
        }

        "getAirportData invokes fetchData" {
            every { Airport.fetchData("IAD") } returns
                    """{"IATA":"IAD", "Name": "Dulles", "Delay": false}"""

            Airport.getAirportData("IAD") shouldBe iad

            verify { Airport.fetchData("IAD") }
        }

        "getAirportData handles error fetching data" {
            every { Airport.fetchData("ERR") } returns "{}"

            Airport.getAirportData("ERR") shouldBe
                    Airport("ERR", "Invalid Airport", false)

            verify { Airport.fetchData("ERR") }
        }

    }
}
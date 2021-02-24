package com.github.elvirka.tasks.educative

import com.github.elvirka.tasks.educative.tryTests.Airport
import com.github.elvirka.tasks.educative.tryTests.getAirportStatus
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class AirportStatusTest : StringSpec() {

    private val iad = Airport("IAD", "Dulles", true)
    private val iah = Airport("IAH", "Houston", false)
    private val inv = Airport("inv", "Invalid Airport", false)

    override fun beforeTest(testCase: TestCase) {
        mockkObject(Airport)
        every { Airport.getAirportData("IAD") } returns iad
        every { Airport.getAirportData("IAH") } returns iah
        every { Airport.getAirportData("inv") } returns inv
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }
    init {
        "getAirportStatus returns status for airports in sorted order" {
            forall(
                row(listOf<String>(), listOf<Airport>()),
                row(listOf("IAD"), listOf(iad)),
                row(listOf("IAD", "IAH"), listOf(iad, iah)),
                row(listOf("IAH", "IAD"), listOf(iad, iah)),
                row(listOf("inv", "IAD", "IAH"), listOf(iad, iah, inv))
            ) { input, result ->
                runBlocking { getAirportStatus(input) } shouldBe result
            }
        }

        "getAirportStatus runs in the Dispatcher.IO context" {
            mockkStatic("kotlinx.coroutines.BuildersKt__Builders_commonKt")

            coEvery {
                withContext<List<Airport>>(
                    context = Dispatchers.IO, block = captureCoroutine())
            } answers {
                listOf(iah)
            }
            getAirportStatus(listOf("IAH")) shouldBe listOf(iah)
            coVerify {
                withContext<List<Airport>>(Dispatchers.IO, block = any())
            }
        }

        "getAirportStatus calls getAirportData asynchronously" {
            mockkStatic("kotlinx.coroutines.BuildersKt__Builders_commonKt")

            coEvery {
                any<CoroutineScope>().async<Airport>(
                    context = any(), block = captureCoroutine())
            } answers {
                CompletableDeferred(iad)
            }
            getAirportStatus(listOf("IAD")) shouldBe listOf(iad)

            coVerify {
                any<CoroutineScope>().async<Airport>(context = any(), block = any())
            }
        }
    }
}
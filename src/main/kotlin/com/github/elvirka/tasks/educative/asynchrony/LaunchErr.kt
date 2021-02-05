package com.github.elvirka.tasks.educative.asynchrony

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { context, ex ->
        println(
            "Caught: ${context[CoroutineName]} ${ex.message?.substring(0..28)}")
    }
    try {
        val airportCodes = listOf("LAX", "SF-", "PD-", "SEA")

        val jobs: List<Job> = airportCodes.map { anAirportCode ->
            launch(Dispatchers.IO + CoroutineName(anAirportCode) +
                    handler + SupervisorJob())
            {
                val airport = Airport.getAirportData(anAirportCode)
                println("${airport?.code} delay: ${airport?.delay}")
            }
        }

        jobs.forEach { it.join() }
        jobs.forEach { println("Cancelled: ${it.isCancelled}") }
    } catch(ex: Exception) {
        println("ERROR: ${ex.message}")
    }
}


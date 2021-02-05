package com.github.elvirka.tasks.educative.asynchrony

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
/*
    println(String.format(FORMAT, "Code", "Temperature", "Delay"))
    val time = measureTimeMillis { getData() }
    println("Time taken $time ms")
    println()
*/
    println(String.format(FORMAT, "Code", "Temperature", "Delay"))
    val asyncTime = measureTimeMillis { asyncGetData() }
    println("Time taken $asyncTime ms")
}

const val FORMAT = "%-10s%-20s%-10s"

fun getData() {
    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")

    val airportData: List<Airport> =
        airportCodes.mapNotNull { anAirportCode ->
            Airport.getAirportData(anAirportCode)
        }

    airportData.forEach { anAirport ->
        println(String.format(FORMAT, anAirport.code,
            anAirport.weather.temperature[0], anAirport.delay))
    }
}

fun asyncGetData() = runBlocking {
    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")

    val airportData: List<Deferred<Airport?>> =
        airportCodes.map { anAirportCode ->
            async(Dispatchers.IO) {
                Airport.getAirportData(anAirportCode).also {
                    println(" " + Thread.currentThread())
                }
            }
        }
    airportData
        .mapNotNull { anAirportData -> anAirportData.await() }
        .forEach { anAirport ->
            println(
                String.format(
                    FORMAT, anAirport.code,
                    anAirport.weather.temperature[0], anAirport.delay
                )
            )
        }
}

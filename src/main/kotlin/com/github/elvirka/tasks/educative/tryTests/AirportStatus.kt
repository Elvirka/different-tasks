package com.github.elvirka.tasks.educative.tryTests

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

suspend fun getAirportStatus(airportCodes: List<String>): List<Airport> =
    withContext(Dispatchers.IO) {
        airportCodes
            .map { async { Airport.getAirportData(it) } }
            .map { it.await() }
            .let { Airport.sort(it) }
    }

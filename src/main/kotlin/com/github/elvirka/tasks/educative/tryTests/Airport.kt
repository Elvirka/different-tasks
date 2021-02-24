package com.github.elvirka.tasks.educative.tryTests

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon

data class Airport(
    @Json(name = "IATA") val code: String,
    @Json(name = "Name") val name: String,
    @Json(name = "Delay") val delay: Boolean){

    companion object {
        fun sort(airports: List<Airport>) : List<Airport> {
            return airports.sortedBy { it.name }
        }

        fun getAirportData(code: String) =
            try {
                Klaxon().parse<Airport>(fetchData(code)) as Airport
            } catch (ex: Exception) {
                Airport(code, "Invalid Airport", false)
            }

        fun fetchData(code: String): String =
            java.net.URL("https://soa.smext.faa.gov/asws/api/airport/status/$code")
                .readText()
    }
}

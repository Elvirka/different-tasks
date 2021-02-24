package com.github.elvirka.tasks.educative.tryTests

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    getAirportStatus(listOf("SFO", "IAD", "IAH", "ORD", "LAX", "ERR"))
        .forEach { println(it) }
}
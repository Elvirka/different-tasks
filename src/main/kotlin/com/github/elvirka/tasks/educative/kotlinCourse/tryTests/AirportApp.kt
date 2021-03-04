package com.github.elvirka.tasks.educative.kotlinCourse.tryTests

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    getAirportStatus(listOf("SFO", "IAD", "IAH", "ORD", "LAX", "ERR"))
        .forEach { println(it) }
}
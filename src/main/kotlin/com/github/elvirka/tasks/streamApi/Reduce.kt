package com.github.elvirka.tasks.streamApi

fun main() {
    val stat = listOf(1,2,3).stream()
            .reduce(
                    0 to 0,
                    { pair, number ->
                        val sum: Int = pair.first + number
                        val count: Int = pair.second + 1
                        sum to count
                    }
            ) { pair1, pair2 ->
                val newSum: Int = pair1.first + pair2.first
                val newCount: Int = pair1.second + pair2.second
                newSum to newCount
            }
    println(stat)
}
package com.github.elvirka.tasks.codeforces.archive

import kotlin.math.max

fun main() {
    val r = System.`in`.bufferedReader()
    val number = r.readLine()!!.toInt()
    val stewards = r.readLine()!!
        .split(" ")
        .map(String::toInt)
        .sorted()

    val minCount = stewards.count{ it == stewards.first() }
    val maxCount = stewards.count{ it == stewards.last() }
    println(max(0, number-maxCount-minCount))
}
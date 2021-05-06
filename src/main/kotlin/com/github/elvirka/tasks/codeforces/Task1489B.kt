package com.github.elvirka.tasks.codeforces

import java.util.Scanner
import kotlin.math.min

fun main() {
    task1489B()
}

fun task1489B() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    for (i in 1..n) {
        val v = scanner.nextLong()
        val b1 = scanner.nextInt()
        val b2 = scanner.nextInt()
        count(v, intArrayOf(b1,b2))
    }
}

fun count(num: Long, costs: IntArray) {
    val values = LongArray((num + 1).toInt())
    values[0] = 0
    for (i in 1..num.toInt()) {
        values[i] = Long.MAX_VALUE
        for (c in 1..2) {
            if (i - c >= 0) {
                values[i] = min(values[i], values[i - c] + costs[c - 1])
            }
        }
    }
    println(values[num.toInt()])
}
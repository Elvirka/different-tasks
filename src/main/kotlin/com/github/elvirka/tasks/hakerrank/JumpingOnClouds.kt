package com.github.elvirka.tasks.hakerrank

import java.util.Scanner
import kotlin.math.min


fun jumpingOnCloudsOld(clouds: IntArray): Int {
    val values = IntArray(clouds.size)
    values[0] = 0
    for (i in 1 until clouds.size) {
        values[i] = Int.MAX_VALUE
        if (clouds[i] == 1) continue
        for (c in 1..2) {
            if (i - c >= 0 && clouds[i - c] != 1) {
                values[i] = min(values[i], values[i - c] + 1)
            }
        }
    }
    return values[clouds.size-1]
}

fun jumpingOnClouds(number: Int, clouds: IntArray): Int {
    var counter = 0
    var i = 0
    while (i < number - 1) {
        if (i + 2 > number - 1 || clouds[i + 2] == 1) {
            i++; counter++
        } else {
            i += 2; counter++
        }
    }
    return counter
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val clouds = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    val result = jumpingOnClouds(n, clouds)

    println(result)
}
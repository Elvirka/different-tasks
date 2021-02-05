package com.github.elvirka.tasks.hakerrank

import java.util.Scanner
import kotlin.io.*
import kotlin.math.max
import kotlin.math.min
import kotlin.text.*

fun main() {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()

    val arr = LongArray(n + 1)
    var maxB1 = 0
    var minA = 0
    var query: Array<String>; var a: Int; var b: Int; var k: Long; var b1: Int
    for (i in 0 until m) {
        query = scan.nextLine().split(' ').toTypedArray()
        a = query[0].toInt()
        b = query[1].toInt()
        k = query[2].toLong()
        arr[a] = arr[a] + k
        b1 = b + 1
        maxB1 = max(maxB1, b1)
        minA = min(minA, a)
        if (b1 <= n) arr[b1] = arr[b1] - k
    }
    var max = 0L; var sum = 0L
    for (i in minA until maxB1) {
        if (arr[i] == 0L) continue
        sum += arr[i]
        max = max(max, sum)
    }
    println(max)
}

package com.github.elvirka.tasks.hakerrank

import java.lang.Integer.min
import java.util.Scanner
import java.util.Arrays


fun equal(arr: IntArray): Int {
    Arrays.sort(arr)
    var sum = Int.MAX_VALUE

    for (base in listOf(0,1,2,5)) {
        var currentSum = 0
        for (element in arr) {
            val delta: Int = element - arr[0] + base
            currentSum += delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1
        }
        sum = min(currentSum, sum)
    }

    return sum
}

fun main() {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()
        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
        val result = equal(arr)

        println(result)
    }
}
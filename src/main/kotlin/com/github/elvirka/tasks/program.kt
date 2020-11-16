package com.github.elvirka.tasks

import java.util.Scanner
import java.util.UUID
import kotlin.math.max

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var max = Int.MIN_VALUE
    for (i in 1 until arr.lastIndex){
        for (j in 1 until arr.lastIndex){
            val sum = arr[i][j] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] +
                    arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]
            max = max(max, sum)
        }
    }
    return max
}

fun main(args: Array<String>) {
    println(UUID.randomUUID())

    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6) { Array<Int>(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}

package com.github.elvirka.tasks.hakerrank

import java.util.Scanner

fun miniMaxSum(arr: Array<Int>): Unit {
    arr.sorted().let { list ->
        val min: Long = list.slice(0 until 4).sumOf { it.toLong() }
        val max: Long = list.slice(arr.lastIndex downTo  arr.lastIndex - 4 + 1).sumOf { it.toLong() }
        println("$min $max")
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}

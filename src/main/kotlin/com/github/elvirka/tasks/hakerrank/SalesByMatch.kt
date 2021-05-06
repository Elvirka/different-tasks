package com.github.elvirka.tasks.hakerrank

import java.util.BitSet
import java.util.Scanner

fun sockMerchant(n: Int, ar: IntArray): Int {
    val pairs = BitSet()
    var counter = 0
    for (s in ar) {
        if (!pairs.get(s)) {
            pairs.set(s)
        } else {
            counter++
            pairs.clear(s)
        }
    }
    return counter
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()
    val result = sockMerchant(n, ar)

    println(result)
}
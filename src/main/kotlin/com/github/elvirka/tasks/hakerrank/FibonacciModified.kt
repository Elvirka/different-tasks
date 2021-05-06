package com.github.elvirka.tasks.hakerrank

import java.math.BigInteger
import java.util.Scanner

fun fibonacciModified(t1: Int, t2: Int, n: Int): BigInteger =
    when(n) {
        1 -> t1.toBigInteger()
        2 -> t2.toBigInteger()
        else -> {
            var ts1 = t2.toBigInteger()
            var ts2 = t1.toBigInteger()
            for(i in 3..n) {
                ts2 = ts1.also { ts1 = ts1 * ts1 + ts2 }
            }
            ts1
        }
    }

fun main() {
    val scan = Scanner(System.`in`)

    val t1T2n = scan.nextLine().split(" ")

    val t1 = t1T2n[0].trim().toInt()
    val t2 = t1T2n[1].trim().toInt()
    val n = t1T2n[2].trim().toInt()

    val result = fibonacciModified(t1, t2, n)

    println(result)
}
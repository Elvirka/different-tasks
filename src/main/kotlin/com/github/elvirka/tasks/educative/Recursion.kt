package com.github.elvirka.tasks.educative

import java.math.BigInteger
import kotlin.system.measureTimeMillis

fun main() {
    //println(factorialIterative(50000))
    println(factorial(5))
    //println(factorialRec(50000))

    lateinit var fib: (Int) -> Long

    fib = { n: Int ->
        when (n) {
            0, 1 -> 1L
            else -> fib(n - 1) + fib(n - 2)
        }
    }.memoize()
    println(measureTimeMillis { fib(40) })
    println(measureTimeMillis { fib(45) })
}

fun fib(n: Int) : Long = when (n) {
    0, 1 -> 1L
    else -> fib(n - 1) + fib(n - 2)
}

fun <T, R> ((T) -> R).memoize(): ((T) -> R) {
    val original = this
    val cache = mutableMapOf<T, R>()

    return { n: T -> cache.getOrPut(n) { original(n) } }
}

fun factorialRec(n: Int): BigInteger =
    if (n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)

tailrec fun factorial(n: Int, result: BigInteger = 1.toBigInteger()): BigInteger =
    if (n <= 0) result else factorial(n - 1, result * n.toBigInteger())

fun factorialIterative(n: Int) =
    (1..n).fold(BigInteger("1")) { product, e -> product * e.toBigInteger() }

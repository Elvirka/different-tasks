package com.github.elvirka.tasks.educative

fun main() {
    //val primes = generateSequence(5, ::nextPrime)
    val primes = sequence {
        var i: Long = 0
        while (true) {
            i++
            if (isPrime(i)) {
                yield(i)
            }
        }
    }
    println(primes.drop(2).take(6).toList())
    //println(primes.take(6).toList())
}

fun isPrime(n: Long) = n > 1 && (2 until n).none { i -> n % i == 0L }

tailrec fun nextPrime(n: Long): Long =
    if (isPrime(n + 1)) n + 1 else nextPrime(n + 1)



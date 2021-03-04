package com.github.elvirka.tasks.educative.kotlinCourse

fun main() {
    val incrementAndDouble = ::increment.andThen(::double).andThen(::plus5)
    println(incrementAndDouble(5))
}

fun increment(number: Int): Double = number + 1.toDouble()
fun double(number: Double) = number * 2
fun plus5(number: Double) = number + 5

fun <T, R, U> ((T) -> R).andThen(next: (R) -> U): (T) -> U =
    { input: T -> next(this(input)) }





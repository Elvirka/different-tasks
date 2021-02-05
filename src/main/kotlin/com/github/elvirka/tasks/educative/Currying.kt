package com.github.elvirka.tasks.educative

fun main() {
    val plus = { x: Int, y: Int -> x + y }
    val curriedPlus = { x: Int -> { y: Int -> x + y } }

    println(plus(3, 5))
    println(curriedPlus(3)(5))
}


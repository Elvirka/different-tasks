package com.github.elvirka.tasks.archive.task339A

fun main() {
    val numbers = readLine()!!.split("+").sorted()
    println(numbers.joinToString("+"))
}
package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val numbers = readLine()!!.split("+").sorted()
    println(numbers.joinToString("+"))
}
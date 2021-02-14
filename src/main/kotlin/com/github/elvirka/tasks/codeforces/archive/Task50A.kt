package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val (m, n) = readLine()!!.split(" ").map(String::toInt)
    println( (m * n) / 2 )
}
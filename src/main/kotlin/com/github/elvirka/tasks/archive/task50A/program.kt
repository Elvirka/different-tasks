package com.github.elvirka.tasks.archive.task50A

fun main() {
    val (m, n) = readLine()!!.split(" ").map(String::toInt)
    println( (m * n) / 2 )
}
package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val n = readLine()!!.toInt()
    val xLevels = readLine()!!.split(" ").map(String::toInt).drop(1)
    val yLevels = readLine()!!.split(" ").map(String::toInt).drop(1)
    val bothLevels = hashSetOf<Int>()
    xLevels.map {
        bothLevels.add(it)
    }
    yLevels.map {
        bothLevels.add(it)
    }
    if (bothLevels.size == n)
        println("I become the guy.")
    else
        println("Oh, my keyboard!")
}
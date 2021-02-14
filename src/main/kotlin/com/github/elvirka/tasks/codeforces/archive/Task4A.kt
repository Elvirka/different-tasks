package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val weight = readLine()!!.toInt()
    print(if (weight > 2 && (weight and 1) == 0) "YES" else "NO")
}
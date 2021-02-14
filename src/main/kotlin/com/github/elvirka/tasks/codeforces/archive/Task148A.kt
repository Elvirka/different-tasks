package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val k = readLine()!!.toInt()
    val l = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    var damagedDragonsCount = 0
    (1..d).map {
        if ( (it%k == 0) || (it%l == 0) || (it%m == 0) || (it%n == 0) )
            damagedDragonsCount++
    }
    println(damagedDragonsCount)
}
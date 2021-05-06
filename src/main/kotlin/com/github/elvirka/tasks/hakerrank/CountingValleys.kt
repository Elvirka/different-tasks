package com.github.elvirka.tasks.hakerrank

fun countingValleysOld(steps: Int, path: String): Int {
    val d = path.toCharArray()
    val h = IntArray(d.size) { 0 }
    for ((index, value) in d.withIndex()) {
        val prev = if (index - 1 >= 0) h[index - 1] else 0
        if (value == 'D') h[index] = prev - 1 else h[index] = prev + 1
    }
    var counter = 0
    for ((index, value) in h.withIndex()) {
        val prev = if (index - 1 >= 0) h[index - 1] else 0
        if (value < 0 && prev == 0) counter++
    }
    //println(h.joinToString())
    return counter
}

fun countingValleys(steps: Int, path: String): Int {
    val d = path.toCharArray()
    var level = 0
    var counter = 0
    for (value in d) {
        if (value == 'D') level--
        else {
            level++
            if (level == 0) counter++
        }
    }
    return counter
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
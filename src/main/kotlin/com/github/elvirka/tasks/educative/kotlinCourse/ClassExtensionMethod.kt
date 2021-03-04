package com.github.elvirka.tasks.educative.kotlinCourse

private class Point(x: Int, y: Int) {
    private val pair = Pair(x, y)

    private val firstSign = if (pair.first < 0) "" else "+"
    private val secondSign = if (pair.second < 0) "" else "+"

    override fun toString() = pair.point2String()

    private fun Pair<Int, Int>.point2String() =
        "(${firstSign}${first}, ${this@Point.secondSign}${this.second})"
}

fun main() {
    println(Point(1, -3))
    println(Point(-3, 4))
}





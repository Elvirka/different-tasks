package com.github.elvirka.tasks.educative.kotlinCourse

fun main() {
    val circle = Circle(100, 100, 25)
    val point1 = Point1(110, 110)
    val point2 = Point1(10, 100)

    println(point1 in circle)
    println(point2 in circle)
    println("Area is ${circle.area}")
}

data class Point1(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

operator fun Circle.contains(point: Point1) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius

val Circle.area: Double
    get() = kotlin.math.PI * radius * radius



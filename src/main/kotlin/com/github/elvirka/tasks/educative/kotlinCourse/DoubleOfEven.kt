package com.github.elvirka.tasks.educative.kotlinCourse

import kotlin.random.Random
import kotlin.system.measureNanoTime

fun main() {
    val rand = Random.nextInt(10)
    val list = List(100) {
        measureNanoTime {
            doubleOfEven(rand)
        }
    }
    val list1 = List(100) {
        measureNanoTime {
            doubleOfEvenF(rand)
        }
    }
    println(list.average())
    println(list1.average())
    println(list.average() < list1.average())
}

private fun doubleOfEven(until: Int) {
    var doubleOfEven = mutableListOf<Int>()
    for (i in 1..until) {
        if (i % 2 == 0) {
            doubleOfEven.add(i * 2)
        }
    }
    println(doubleOfEven)
}

private fun doubleOfEvenF(until: Int) {
    val doubleOfEven = (1..until)
        .filter { e -> e % 2 == 0 }
        .map { e -> e * 2 }

    println(doubleOfEven)
}


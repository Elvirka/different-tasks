package com.github.elvirka.tasks.hakerrank

import java.util.Scanner

fun rotLeft(a: IntArray, d: Int): IntArray {
    val tmp = IntArray(a.size)
    a.mapIndexed { index, item ->
        val newIndex = index + a.size - d
        if (newIndex < a.size) {
            tmp[newIndex] = item
        } else {
            tmp[newIndex - a.size] = item
        }
    }
    return tmp
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")
    val n = nd[0].trim().toInt()
    val d = nd[1].trim().toInt()
    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}



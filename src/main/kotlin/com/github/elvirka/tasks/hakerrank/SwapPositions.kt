package com.github.elvirka.tasks.hakerrank

import java.util.Scanner

fun minimumBribes(q: IntArray) {
    var counter = 0

    for (index in q.size - 1 downTo 0) {
        if (q[index] != index + 1) {
            when {
                index - 1 >= 0 && index + 1 == q[index - 1] -> {
                    counter++
                    q[index] = q[index - 1]
                        .also { q[index - 1] = q[index] }
                }
                index - 2 >= 0 && index + 1 == q[index - 2] -> {
                    counter += 2
                    q[index] = q[index - 2]
                        .also { q[index - 1] = q[index]
                            .also { q[index - 2] = q[index - 1] }
                        }
                }
                else -> { println("Too chaotic"); return }
            }
        }
    }
    println(counter)
}

fun main() {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()
        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

        minimumBribes(q)
    }
}
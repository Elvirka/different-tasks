package com.github.elvirka.tasks.hakerrank

import java.util.Scanner

private val scanner = Scanner(System.`in`)

fun main() {
    val testCasesNum = scanner.nextLine().toInt()
    for (i in 1..testCasesNum){
        val shelvesNum = scanner.nextLine().toInt()
        val shelves = scanner.nextLine().split(" ").map { it.toInt() }.toIntArray()
        val queriesNum = scanner.nextLine().toInt()
        for (j in 1..queriesNum){
            val query = scanner.nextLine().split(" ").map { it.toInt() }.toIntArray()
            if (query[0] == 0) {
                val (_, x, y, k) = query
                for (f in x-1..y-1) {
                    //if (shelves[f] == shelvesSorted[k-1])
                    println(shelves[f])
                }
            }
            else {
                val (_, x, k) = query
                shelves[x-1] = k
            }
        }
    }
}


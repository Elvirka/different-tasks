package com.github.elvirka.tasks.codeforces.archive

import java.util.Scanner

val scanner = Scanner(System.`in`)

fun main() {
    task231A()
}

fun task231A() {
    val number = scanner.nextInt()
    scanner.nextLine()
    var taskToSolve = 0
    for (i in 1..number) {
        val s = scanner.nextLine()
        val fs = charArrayOf(s[0], s[2], s[4])
            .filter { it == '1' }.size
        if (fs > 1) taskToSolve++
    }
    println(taskToSolve)
}
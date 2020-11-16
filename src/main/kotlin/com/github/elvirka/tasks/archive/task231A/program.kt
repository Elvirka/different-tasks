package com.github.elvirka.tasks.archive.task231A

fun main() {
    val number = readLine()!!.toInt()
    var taskToSolve = 0
    (0 until number).map {
        if ( readLine()!!.split(" ").filter { it == "1" }.size > 1)
            taskToSolve++
    }
    println(taskToSolve)
}
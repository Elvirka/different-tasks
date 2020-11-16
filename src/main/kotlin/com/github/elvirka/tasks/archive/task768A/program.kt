package com.github.elvirka.tasks.archive.task768A

fun main() {
    val number = readLine()!!.toInt()
    val stewards = readLine()!!
        .split(" ")
        .map(String::toInt)
        .sorted()
    var res = number - 2
    for (i in 1 until number) {
        if (stewards[i] == stewards[i - 1]) res--
        else break
    }
    for (i in number-2 downTo 0){
        if (stewards[i] == stewards[i+1]) res--
        else break
    }
    if (res > 0) println(res) else println(0)
}
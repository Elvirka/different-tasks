package com.github.elvirka.tasks.hakerrank

import java.util.Scanner

fun repeatedString(s: String, n: Long): Long {
    var aNum = 0
    var aRestNum = 0
    for ((index, value) in s.toCharArray().withIndex()) {
        if (value == 'a') aNum++
        if (index < n % s.length && value == 'a') aRestNum++
    }
    return aNum * (n / s.length) + aRestNum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine()
    val n = scan.nextLine().trim().toLong()
    val result = repeatedString(s, n)

    println(result)
}
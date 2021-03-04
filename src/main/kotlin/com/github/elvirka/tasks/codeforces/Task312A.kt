package com.github.elvirka.tasks.codeforces

import java.util.Scanner

fun main() {
    task312A()
}

fun task312A() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    scanner.nextLine()
    for (i in 1..n){
        val s = scanner.nextLine()
        if (s.length < 5) {
            println("OMG>.< I don't know!")
            continue
        }
        val first = s.substring(0..4)
        val last = s.substring(s.length-5 until s.length)
        val res = when {
            first == "miao." && last != "lala." -> "Rainbow's"
            last == "lala." && first != "miao." -> "Freda's"
            else -> "OMG>.< I don't know!"
        }
        println(res)
    }
}
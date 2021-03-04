package com.github.elvirka.tasks.codeforces

import java.util.BitSet
import java.util.Scanner

fun main() {
    task1489A()
}

fun task1489A() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val check = BitSet()
    val arr = IntArray(n)
    for (i in n-1 downTo 0) {
        val num = scanner.nextInt()
        arr[i] = num
        check.set(num)
    }
    val size = check.cardinality()
    println(size)
    val res = IntArray(size)
    var cur = size - 1
    for (num in arr) {
        if(check.get(num)) {
            res[cur] = num
            cur--
            check.clear(num)
            if(cur < 0) {break}
        }
    }
    println(res.joinToString(" "))
}
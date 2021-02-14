package com.github.elvirka.tasks.codeforces

fun main() {
    val t = readLine()!!.toInt()
    (1..t).map {
        val (_, k) = readLine()!!.split(" ").map(String::toInt)
        val p = readLine()!!.split(" ").map(String::toInt).reversed()
        var max = 0
        var pos = mutableListOf<Int>()
        p.map { money ->
            pos.add(money)
            val num = pos.size / k
            var sum = 0
            if (num != 0) {
                sum = pos.slice( pos.lastIndex downTo  pos.lastIndex-num + 1).sum()
            }
            max = maxOf(max, sum)
        }
        println(max)
    }
}
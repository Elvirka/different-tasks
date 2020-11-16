package com.github.elvirka.tasks.archive.task490A

fun main() {
    val number = readLine()!!.toInt()
    val skills = readLine()!!.split(" ").map(String::toInt)

    val pr = arrayListOf<Int>()
    val mt = arrayListOf<Int>()
    val pe = arrayListOf<Int>()
    skills.mapIndexed { index, value ->
        when(value){
            1 -> pr.add(index + 1)
            2 -> mt.add(index + 1)
            else -> pe.add(index + 1)
        }
    }
    val min = minOf(pr.size, mt.size, pe.size)
    println(min)
    for (i in 0 until min) {
        println("${pr[i]} ${mt[i]} ${pe[i]}")
    }
}
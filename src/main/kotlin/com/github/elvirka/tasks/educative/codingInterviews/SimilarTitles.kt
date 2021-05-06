package com.github.elvirka.tasks.educative.codingInterviews

fun main() {
    val titles = listOf("duel", "dule", "speed", "spede", "deul", "cars")
    val dictionary = titles.groupBy {
        val hash = IntArray(26) { 0 }
        for (s in it) {
            hash[(s - 'a')]++
        }
        hash.joinToString("#")
    }.mapValues { it.value.toSet() }

    println(dictionary)
}

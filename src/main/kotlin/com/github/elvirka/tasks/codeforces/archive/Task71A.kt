package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val number = readLine()!!.toInt()
    val words: Array<String> = Array(number) { "" }
    (0 until number).map {
        val word = readLine()!!
        if (word.length > 10)
            words[it] = word.first() + (word.length-2).toString() + word.last()
        else
            words[it] = word
    }
    words.map {
        println(it)
    }
}
package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val vowels = setOf('a', 'o', 'y', 'e', 'u', 'i')
    val input = readLine()!!
    val letters = Array(input.length) { "" }
    var index = 0
    input.map {
        if (!vowels.contains(it.toLowerCase()))
            letters[index] = ".${it.toLowerCase()}"; index++
    }
    println(letters.joinToString(""))
}
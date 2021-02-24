package com.github.elvirka.tasks.educative

fun main() {
    val javaObject = JavaClassForKotlin()
    println(javaObject.zero)

    println(javaObject.convertToUpper(listOf("Jack", "Jill")))
    javaObject.suspend()
    println(javaObject.`when`())
}
package com.github.elvirka.tasks.educative.kotlinCourse

import com.github.elvirka.tasks.educative.JavaClassForKotlin

fun main() {
    val javaObject = JavaClassForKotlin()
    println(javaObject.zero)

    println(javaObject.convertToUpper(listOf("Jack", "Jill")))
    javaObject.suspend()
    println(javaObject.`when`())
}
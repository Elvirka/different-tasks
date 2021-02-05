package com.github.elvirka.tasks.educative

import kotlin.reflect.KProperty

class PoliteString(var content: String) {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>) =
        content.replace("stupid", "s*****")

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, value: String) {
        content = value
    }
}

fun politeString(content: String) = PoliteString(content)

fun main() {
    println()
    var comment: String by politeString("Some nice message")
    println(comment)
    comment = "This is stupid"
    println(comment)
    println("comment is of length: ${comment.length}")
}
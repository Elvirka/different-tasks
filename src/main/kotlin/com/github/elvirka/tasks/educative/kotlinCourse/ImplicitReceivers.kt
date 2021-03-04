package com.github.elvirka.tasks.educative.kotlinCourse

fun main() {
    // val length = 100

    val printIt: String.(Int) -> Unit = { n: Int ->
        println("n is $n, length is $length")
    }
    printIt("Hello", 6)
    "Hello".printIt(6)

    top {
        println("In outer lambda $this and $length")

        nested {
            println("in inner lambda $this and ${toDouble()}")
            println("from inner through receiver of outer: $length")
            println("from inner to outer receiver ${this@top}")
        }
    }
}

fun top(func: String.() -> Unit) = "hello".func()

fun nested(func: Int.() -> Unit) = (-2).func()



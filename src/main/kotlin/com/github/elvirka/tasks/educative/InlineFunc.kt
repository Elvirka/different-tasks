package com.github.elvirka.tasks.educative

fun main() {
    callInvokeTwo()
}

fun callInvokeTwo() {
    invokeTwo(1, { i ->
        if (i == 1) { return }

        report(i)
    }, { i ->
        //if (i == 2) { return }| //ERROR, return not allowed here
        report(i)
    })
    println("after return from callInvokeTwo")
}

fun report(n: Int) {
    println("")
    print("called with $n, ")

    val stackTrace = RuntimeException().stackTrace

    println("Stack depth: ${stackTrace.size}")
    println("Partial listing of the stack:")
    stackTrace.take(5).forEach(::println)
}

inline fun invokeTwo(
    n: Int,
    action1: (Int) -> Unit,
    crossinline action2: (Int) -> Unit //ERROR
): (Int) -> Unit {

    println("enter invokeTwo $n")

    action1(n)

    println("exit invokeTwo $n")
    return { input: Int -> action2(input) }
}





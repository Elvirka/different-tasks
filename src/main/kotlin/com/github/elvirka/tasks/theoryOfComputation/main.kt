package com.github.elvirka.tasks.theoryOfComputation

fun main() {
    val expr = Add(
        Multiply(Number(1), Number(2)),
        Multiply(Number(3), Number(4))
    )
    Machine(expr, mapOf()).run()

    val lessExpr = LessThan(
        Number(5),
        Add(Number(2), Number(2))
    )
    Machine(lessExpr, mapOf()).run()

    val varExpr = Add(
        Variable("x"), Variable("y"),
    )
    Machine(
        varExpr,
        mapOf("x" to Number(3), "y" to Number(5))
    ).run()

    val assignExpr = Assign("x", Add(Variable("x"), Number(1)))
    val env = mapOf("x" to Number(3))
    Machine(
        assignExpr, env
    ).run()
}
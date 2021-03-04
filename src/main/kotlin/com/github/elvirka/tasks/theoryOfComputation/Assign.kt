package com.github.elvirka.tasks.theoryOfComputation

data class Assign(val name: String, val expression: Object): Reducible {
    override fun toString(): String = "$name = $expression"

    override fun reducible() = true

    override fun reduce(environment: Map<String, Object>): Pair<Object, Map<String, Object>?> =
        when {
            expression.reducible() -> {
                Assign(name, (expression as Reducible).reduce(environment).first) to environment
            }
            else -> {
                Nothing() to environment + (name to expression)
            }
        }
}
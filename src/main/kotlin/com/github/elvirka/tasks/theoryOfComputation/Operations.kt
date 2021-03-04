package com.github.elvirka.tasks.theoryOfComputation

interface Reducible: Object {
    fun reduce(environment: Map<String, Object>) : Pair<Object, Map<String, Object>?>
}

data class Add(val left: Object, val right: Object): Reducible {
    override fun toString(): String =
        "$left + $right"

    override fun reducible() = true

    override fun reduce(environment: Map<String, Object>): Pair<Object, Map<String, Object>?> =
        when {
            left.reducible() -> {
                Add((left as Reducible).reduce(environment).first, right)
            }
            right.reducible() -> {
                Add(left, (right as Reducible).reduce(environment).first)
            }
            else -> {
                Number((left as Number).value + (right as Number).value)
            }
        }.let { it to null }
}

data class Multiply(val left: Object, val right: Object): Reducible{
    override fun toString(): String =
        "$left * $right"

    override fun reduce(environment: Map<String, Object>): Pair<Object, Map<String, Object>?> =
        when {
            left.reducible() -> {
                Multiply((left as Reducible).reduce(environment).first, right)
            }
            right.reducible() -> {
                Multiply(left, (right as Reducible).reduce(environment).first)
            }
            else -> {
                Number((left as Number).value * (right as Number).value)
            }
        }.let { it to null }

    override fun reducible() = true
}

data class LessThan(val left: Object, val right: Object): Reducible{
    override fun toString(): String =
        "$left < $right"

    override fun reduce(environment: Map<String, Object>): Pair<Object, Map<String, Object>?> =
        when {
            left.reducible() -> {
                LessThan((left as Reducible).reduce(environment).first, right)
            }
            right.reducible() -> {
                LessThan(left, (right as Reducible).reduce(environment).first)
            }
            else -> {
                Bool((left as Number).value < (right as Number).value)
            }
        }.let { it to null }

    override fun reducible() = true
}
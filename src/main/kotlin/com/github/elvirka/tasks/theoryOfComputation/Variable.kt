package com.github.elvirka.tasks.theoryOfComputation


data class Variable(val name: String): Reducible {
    override fun toString(): String = name

    override fun reducible() = true

    override fun reduce(environment: Map<String, Object>): Pair<Object, Map<String, Object>?> =
        environment[name]!! to null
}
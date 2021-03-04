package com.github.elvirka.tasks.theoryOfComputation

class Nothing(): Object {
    override fun toString(): String =
        "do-nothing"

    override fun reducible() = false

    override fun equals(other: Any?): Boolean =
        other is Nothing
}
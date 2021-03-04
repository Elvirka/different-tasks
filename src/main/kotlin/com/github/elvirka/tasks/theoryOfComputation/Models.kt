package com.github.elvirka.tasks.theoryOfComputation

interface Object {
    fun reducible(): Boolean
}

data class Number(val value: Int): Object {
    override fun toString(): String =
        value.toString()

    override fun reducible() = false
}

data class Bool(val value: Boolean): Object {
    override fun toString(): String =
        value.toString()

    override fun reducible() = false
}


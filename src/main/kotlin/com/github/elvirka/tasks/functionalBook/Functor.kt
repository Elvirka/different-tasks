package com.github.elvirka.tasks.functionalBook

fun main() {
    println(Option.Some("Kotlin")
        .map(String::toUpperCase))
    println(Option.None.map(String::toUpperCase))

    val add3AndMultiplyBy2: (Int) -> Int = { i: Int -> i + 3 }
        .map { j -> j * 2 }
    println(add3AndMultiplyBy2(0))
    println(add3AndMultiplyBy2(1))
    println(add3AndMultiplyBy2(2))

    println("------Monads------")
    println(calculateDiscount(Option.Some(80.0)))
    println(calculateDiscount(Option.Some(30.0)))
    println(calculateDiscount(Option.None))

    val maybeFive = Option.Some(5)
    val maybeTwo = Option.Some(2)
    println(
        maybeFive.flatMap { f ->
            maybeTwo.flatMap { t ->
                Option.Some(f + t)
            }
        }
    )
    println(
        maybeFive.flatMap { f ->
            maybeTwo.map { t -> f + t }
        }
    )

    val numbers = listOf(1, 2, 3)
    val functions = listOf<(Int) -> Int>({ i -> i * 2 }, { i -> i + 3 })
    val result = numbers.flatMap { number ->
        functions.map { f -> f(number) }
    }.joinToString()
    println(result)
}

fun <A, B, C> ((A) -> B).map(transform: (B) -> C): (A) -> C = { t -> transform(this(t)) }

sealed class Option<out T> {
    object None : Option<Nothing>() {
        override fun toString() = "None"
    }
    data class Some<out T>(val value: T) : Option<T>()

    companion object
}

fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> =
    when (this) {
        Option.None -> Option.None
        is Option.Some -> Option.Some(transform(value))
}

fun <T, R> Option<T>.flatMap(fm: (T) -> Option<R>): Option<R> =
    when (this) {
        Option.None -> Option.None
        is Option.Some -> fm(value)
    }

fun calculateDiscount(price: Option<Double>): Option<Double> {
    return price.flatMap { p ->
        if (p > 50.0) {
            Option.Some(5.0)
        } else {
            Option.None
        }
    }
}
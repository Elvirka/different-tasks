package com.github.elvirka.tasks.educative

enum class Suit(val symbol: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665') {
        override fun display() = "${super.display()} $symbol"
    },
    SPADES('\u2660');

    open fun display() = "$symbol $name"
}

fun main() {
    for (suit in Suit.values()) {
        println(suit.display())
    }
    Suit.values().map {
        println(it.javaClass)
    }
}



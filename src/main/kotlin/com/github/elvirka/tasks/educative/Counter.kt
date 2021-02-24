@file:JvmName("CounterTop")
package com.github.elvirka.tasks.educative

fun main(){
    val counter = Counter(1)
    println(counter + counter)

    println(counter.map { ctr -> ctr + ctr })

    try {
        counter.readFile("blah")
    } catch(ex: java.io.FileNotFoundException) {
        println("File not found")
    }

    println(counter.add(3))
    println(counter.add())

    println(createCounter())
}

fun createCounter() = Counter(0)

data class Counter(val value: Int) {
    operator fun plus(other: Counter) = Counter(value + other.value)

    @JvmOverloads
    fun add(n: Int = 1) = Counter(value + n)

    fun map(mapper: (Counter) -> Counter) = mapper(this)

    @Throws(java.io.FileNotFoundException::class)
    fun readFile(path: String) = java.io.File(path).readLines()

    companion object {
        @JvmStatic
        fun create() = Counter(0)
    }
}
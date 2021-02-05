package com.github.elvirka.tasks

import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.scheduler.Schedulers
import java.lang.IllegalArgumentException


fun main() {
    val source = Flux.create { emitter: FluxSink<Int?> ->
        println(Thread.currentThread())
        emitter.next(1)
        emitter.next(2)
        emitter.complete()
    }
    source
        .map { if (it == 2) throw IllegalArgumentException() }
        .map { i -> "$i. element: $i".also { println(Thread.currentThread()) } }
        .onErrorResume { throw it }
        .subscribe(::println)

    println("Before or after?")
}


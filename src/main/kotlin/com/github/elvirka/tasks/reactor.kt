package com.github.elvirka.tasks

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.util.function.Function


fun main() {
    val fl1 = Flux.fromIterable(listOf(1,2,3))
    val fl2 = Flux.fromIterable(listOf(1,4))
    val fl3 = fl1.mergeWith(fl2)
    fl3.subscribe { println(it) }

    val a = Flux.just("A", "B", "C")
    val b = Flux.just("B", "C", "D")
    Flux.merge(a, b)
        .groupBy(Function.identity())
        .filterWhen {g -> g.count().map {l -> l>1} }
        .map{ g -> g.key()}
        .subscribe { println(it) }

    println("=================")

    a.collectList().flatMapMany { ap ->
        val exists = ap.toSet()
        b.filterWhen {
            Mono.just(it !in exists)
        }.concatWith(a)
    }.subscribe { println(it) }

    println("=================")

    Mono.zip(
        1.toMono(),
        1.toMono(),
    ).map { data ->
        data.t1 + data.t2
    }.subscribe { println(it)}

}

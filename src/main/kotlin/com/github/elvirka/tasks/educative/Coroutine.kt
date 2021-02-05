package com.github.elvirka.tasks.educative

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import java.util.concurrent.Executors

@ExperimentalCoroutinesApi
fun main() {
    Executors.newFixedThreadPool(
        Runtime.getRuntime().availableProcessors()
    ).asCoroutineDispatcher().use {
        println("start")

        runBlocking(CoroutineName("top")) {
            launch(context = it, start = CoroutineStart.UNDISPATCHED) { task1() }
            //withContext(Dispatchers.Default) { task1() }
            launch(Dispatchers.Default + CoroutineName("task runner")) { task2() }
            println("called task1 and task2 from ${Thread.currentThread()}")
        }

        runBlocking {
            val count: Deferred<Int> = async(Dispatchers.Default) {
                println("fetching in ${Thread.currentThread()}")
                Runtime.getRuntime().availableProcessors()
            }
            println("called the function in ${Thread.currentThread()}")
            println("number of cores is ${count.await()}")
        }
        println("done")
    }
}

suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    yield()
    println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    yield()
    println("end task2 in Thread ${Thread.currentThread()}")
}


package com.github.elvirka.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis


//val counterContext = newSingleThreadContext("CounterContext")
//@Volatile
val mutex = Mutex()
var counter = 0 //AtomicInteger()

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        //withContext(counterContext) {
        massiveRun {
            mutex.withLock {
                counter++  //.incrementAndGet()
            }
        }
    }
    println("Counter = $counter")
}

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}


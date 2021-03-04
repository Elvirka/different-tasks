package com.github.elvirka.tasks.educative.kotlinCourse.asynchrony

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.net.URL

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        launch { compute(checkActive = false) }
        launch { compute(checkActive = true) }
        launch { fetchResponse(callAsync = false) }
        launch { fetchResponse(callAsync = true) }
    }

    println("Let them run...")
    Thread.sleep(1000)
    println("OK, that's enough, cancel")
    job.cancelAndJoin()

    println()

    val job1 = launch(Dispatchers.Default) {
        launch { doWork(1, 3000) }
        launch { doWork(2, 1000) }
    }

    Thread.sleep(2000)
    job1.cancel()
    println("cancelling")
    job1.join()
    println("done")

    val handler = CoroutineExceptionHandler { _, ex ->
        println("Exception handled: ${ex.message}")
    }
    println()

    val job2 = launch(Dispatchers.IO + SupervisorJob() + handler) {
        withTimeout(3000) {
        //supervisorScope {
            launch { fetchResponse(true, 200, 5000) }
            launch { fetchResponse(true, 202, 1000) }
            launch { fetchResponse(true, 404, 2000) }
        }
    }

    job2.join()
}

suspend fun doWork(id: Int, sleep: Long) = coroutineScope {
    try {
        println("$id: entered $sleep")
        delay(sleep)
        println("$id: finished nap $sleep")

        withContext(NonCancellable) {
            println("$id: do not disturb, please")
            delay(5000)
            println("$id: OK, you can talk to me now")
        }

        println("$id: outside the restricted context")
        println("$id: isActive: $isActive")
    } catch(ex: CancellationException) {
        println("$id: doWork($sleep) was cancelled")
    }
}

suspend fun compute(checkActive: Boolean) = coroutineScope {
    var count = 0L
    val max = 10000000000

    while (if (checkActive) { isActive } else (count < max)) {
        count++
    }
    if (count == max) {
        println("compute, checkActive $checkActive ignored cancellation")
    } else {
        println("compute, checkActive $checkActive bailed out early")
    }
}

fun getResponse(code: Int, delay: Int) = URL("http://httpstat.us/$code?sleep=$delay").readText()

suspend fun fetchResponse(callAsync: Boolean, code: Int = 200, delay: Int = 2000) = coroutineScope {
    try {
        val response = if (callAsync) {
            async { getResponse(code, delay) }.await()
        } else {
            getResponse(code, delay)
        }

        println(response)
    } catch(ex: CancellationException) {
        println("${ex.message} for fetchResponse $code")
    }
}
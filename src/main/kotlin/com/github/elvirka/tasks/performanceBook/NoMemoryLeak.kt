package com.github.elvirka.tasks.performanceBook

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

fun main() {
    var memoryLeak: NoMemoryLeak? = NoMemoryLeak()
    memoryLeak?.start()
    memoryLeak?.disposable?.dispose()
    memoryLeak = NoMemoryLeak()
    memoryLeak.start()
    Thread.currentThread().join()
}

class NoMemoryLeak {

    init {
        objectNumber ++
    }

    private val currentObjectNumber = objectNumber

    var disposable: Disposable? = null

    fun start() {
        disposable = Observable.interval(1, TimeUnit.SECONDS)
            .subscribe { println(currentObjectNumber) }
    }
    companion object {
        @JvmField
        var objectNumber = 0
    }
}
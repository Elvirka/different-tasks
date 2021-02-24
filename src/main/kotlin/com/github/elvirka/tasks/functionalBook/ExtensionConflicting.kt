package com.github.elvirka.tasks.functionalBook

fun main() {
    val worker = Worker()
    println(worker.work())
    println(worker.work("refactoring"))
    println(worker.rest())
    worker.printsmf()
}

class Worker {
    fun work() = "*working hard*"
    private fun rest() = "*resting*"
    fun printsmf() = println(this.rest())
}
fun Worker.work() = "*not working so hard*"
fun <T> Worker.work(t:T) = "*working on $t*"
fun Worker.rest() = "*playing video games*"

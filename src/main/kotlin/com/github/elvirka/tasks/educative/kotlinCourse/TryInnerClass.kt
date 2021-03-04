package com.github.elvirka.tasks.educative.kotlinCourse

interface Remote {
    fun up()
    fun down()

    fun doubleUp() {
        up()
        up()
    }
}

class TV {
    private var volume = 0

    val remote: Remote
        get() = TVRemote()

    override fun toString(): String = "Volume: ${volume}"

    inner class TVRemote : Remote {
        override fun up() { volume++ }
        override fun down() { volume-- }

        override fun toString() = "Remote: ${this@TV.toString()}"
    }
}

fun main() {
    val tv = TV()
    val remote = tv.remote

    println(tv)
    println(remote)
}



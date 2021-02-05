package com.github.elvirka.tasks.educative

import kotlin.reflect.KProperty
import kotlin.collections.MutableMap

class OtherPoliteString(private val dataSource: MutableMap<String, Any>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

class PostComment(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    val comment: String by OtherPoliteString(dataSource)

    override fun toString() = "Title: $title Likes: $likes Comment: $comment"
}

fun getTemperature(city: String): Double {
    println("fetch from webservice for $city")
    return 30.0
}

fun main() {
    val data = listOf(
        mutableMapOf<String, Any>(
            "title" to "Using Delegation",
            "likes" to 2,
            "comment" to "Keep it simple, stupid"),
        mutableMapOf<String, Any>(
            "title" to "Using Inheritance",
            "likes" to 1,
            "comment" to "Prefer Delegation where possible"))

    val forPost1 = PostComment(data[0])
    val forPost2 = PostComment(data[1])

    forPost1.likes++

    println(forPost1)
    println(forPost2)

    val showTemperature = true
    val city = "Boulder"

    val temperature by lazy { getTemperature(city) }

    if (showTemperature && temperature > 20) //(nothing here)
        println("Warm")
    else
        println("Nothing to report")
}
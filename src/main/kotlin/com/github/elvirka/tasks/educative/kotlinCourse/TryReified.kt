package com.github.elvirka.tasks.educative.kotlinCourse

abstract class Book(val name: String)
class Fiction(name: String) : Book(name)
class NonFiction(name: String) : Book(name)


inline fun <reified T> findFirst(books: List<Book>): T {
    val selected = books.filter { book -> book is T }
    if(selected.isEmpty()) {
        throw RuntimeException("Not found")
    }
    return selected[0] as T
}

fun main() {
    val books: List<Book> = listOf(
        Fiction("Moby Dick"), NonFiction("Learn to Code"), Fiction("LOTR")
    )

    println(findFirst<NonFiction>(books).name)
}
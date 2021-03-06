package com.github.elvirka.tasks.educative.kotlinCourse

class Mailer {
    val details: StringBuilder = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr...\n")
    fun subject(line: String) = details.append("subject $line...\n")
    fun body(message: String) = details.append("body $message...\n")
    fun send() = "...sending...\n$details"
}

fun main() {
    val result = Mailer().run {
        from("builder@agiledeveloper.com")
        to("venkats@agiledeveloper.com")
        subject("Your code sucks")
        body("details")
        send()
    }
    println(result)
}


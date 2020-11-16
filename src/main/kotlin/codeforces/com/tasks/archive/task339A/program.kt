package codeforces.com.tasks.archive.task339A

fun main() {
    val numbers = readLine()!!.split("+").sorted()
    println(numbers.joinToString("+"))
}
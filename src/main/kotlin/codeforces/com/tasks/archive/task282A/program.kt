package codeforces.com.tasks.archive.task282A

fun main() {
    val number = readLine()!!.toInt()
    var result = 0
    (0 until number).map {
        val expression = readLine()!!
        if (expression[1] == '+') result++ else result--
    }
    println(result)
}
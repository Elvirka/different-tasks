package codeforces.com.tasks.archive.task4A

fun main() {
    val weight = readLine()!!.toInt()
    print(if (weight > 2 && (weight and 1) == 0) "YES" else "NO")
}
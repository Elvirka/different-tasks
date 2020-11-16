package codeforces.com.tasks.archive.task670A

fun main() {
    val days = readLine()!!.toInt()
    val weeks = days / 7
    var minDaysOff = weeks * 2
    var maxDaysOff = weeks * 2

    when(days % 7) {
        0 -> { }
        1 -> maxDaysOff += 1
        6 -> { maxDaysOff += 2; minDaysOff += 1 }
        else -> maxDaysOff += 2
    }
    println("$minDaysOff $maxDaysOff")
}
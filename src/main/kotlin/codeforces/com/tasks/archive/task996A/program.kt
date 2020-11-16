package codeforces.com.tasks.archive.task996A

fun main() {
    var money = readLine()!!.toInt()
    val bills = intArrayOf(100, 20, 10, 5, 1)
    var billsNumber = 0
    bills.map {
        billsNumber += money / it
        money %= it
    }
    println(billsNumber)
}
package codeforces.com.tasks.task1431A

fun main() {
    val t = readLine()!!.toInt()
    (1..t).map {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map(String::toLong)
        var max = 0L
        a.map { money ->
            var sum = 0L
            a.map {
                if (it >= money) sum += money
            }
            max = maxOf(max, sum)
        }
        println(max)
    }
}
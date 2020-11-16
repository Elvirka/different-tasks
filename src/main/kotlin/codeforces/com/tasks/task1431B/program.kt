package codeforces.com.tasks.task1431B

fun main() {
    val t = readLine()!!.toInt()
    (1..t).map {
        var prevChar: Char = 'a'
        val str = readLine()!!
        var count = 0
        str.map {
            if (it == 'w' || (it == 'v' && prevChar == 'v')){
                count += 1
            }
            if (it == 'v' && prevChar == 'v'){
                prevChar = 'a'
            } else {
                prevChar = it
            }
        }
        println(count)
    }
}
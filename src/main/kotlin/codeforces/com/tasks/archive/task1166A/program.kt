package codeforces.com.tasks.archive.task1166A

fun main() {
    val number = readLine()!!.toInt()
    val names = HashMap<Char, Int>()
    (0 until number).map {
        val name = readLine()!!
        val key = name.first()
        names.put(key, names.getOrPut(key){ 0 } + 1)
    }
    var pairNumber = 0
    names.map {
        val room1 = it.value / 2
        val room2 = it.value - room1
        pairNumber += (room1 * (room1 - 1)) / 2 + (room2 * (room2 - 1)) / 2
    }
    println(pairNumber)
}
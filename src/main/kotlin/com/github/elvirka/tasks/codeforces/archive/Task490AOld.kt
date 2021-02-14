package com.github.elvirka.tasks.codeforces.archive

fun main() {
    val number = readLine()!!.toInt()
    val skills = readLine()!!.split(" ").map(String::toInt)
    val commandsCount = number / 3
    if (commandsCount > 0){
        val teams = Array<HashMap<Int, Int>>(commandsCount) { HashMap() }
        skills.mapIndexed { index, value ->
            val iter = teams.iterator()
            do {
                val res = iter.next().putIfAbsent(value, index+ 1)
            } while (iter.hasNext() && res != null)
        }
        val fullTeams = teams.filter { it.size == 3 }
        println(fullTeams.size)
        fullTeams.map {
            println(it.values.joinToString(" "))
        }
    } else {
        println(0)
    }
}
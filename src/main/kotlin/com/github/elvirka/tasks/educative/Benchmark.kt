package com.github.elvirka.tasks.educative

import kotlin.system.measureNanoTime

class Benchmark(
    private val iterations: Int = 100,
    private val warmUpIterations: Int = 5
){
    fun <T, R> run(input: T, action1: (T) -> R, action2: (T) -> R) {
        val average = (1..iterations).map { iterationNum ->
            println("---- Stage № $iterationNum")
            val list = List(100) {
                measureNanoTime {
                    action1(input)
                }
            }
            val list1 = List(100) {
                measureNanoTime {
                    action2(input)
                }
            }
            if (iterationNum > warmUpIterations) {
                val action1Average = list.average()
                val action2Average = list1.average()

                println("---- ACTION1 average $action1Average")
                println("---- ACTION2 average $action2Average")
                println(
                    if (action1Average < action2Average)
                        "---- ACTION1 faster"
                    else
                        "---- ACTION2 faster"
                )
                Pair(action1Average, action2Average)
            } else {
                null
            }
        }.filterNotNull()

        val action1Res = average.map { it.first }.average()
        val action2Res = average.map { it.second }.average()
        println("-- Result: ACTION1 $action1Res, ACTION2 $action2Res")
        println("-- Average difference: ${action1Res - action2Res}")
    }
}

package com.github.elvirka.tasks.theoryOfComputation

class Machine(var expression: Object, var environment: Map<String, Object>) {

    private fun step(){
        val res = (expression as Reducible).reduce(environment)
        expression = res.first
        if (res.second != null) {
            environment = res.second!!
        }

    }

    fun run(){
        while (expression.reducible()) {
            println("$expression $environment")
            step()
        }
        println("$expression $environment")
    }
}
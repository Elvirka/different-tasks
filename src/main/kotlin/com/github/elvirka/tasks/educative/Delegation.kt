package com.github.elvirka.tasks.educative

interface Worker {
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("Why? Really?")
}
class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVacation() = println("...code at the beach...")
}

class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVacation() = println("...branch at the ranch...")
}

// class Manager : Worker by JavaProgrammer()

class Manager(var staff: Worker) : Worker by staff {
    fun meeting() =
        println("organizing meeting with ${staff.javaClass.simpleName}")

    override fun takeVacation() = println("of course")
}

fun main() {
    val doe = Manager(JavaProgrammer())
    println("Staff is ${doe.staff.javaClass.simpleName}")
    doe.work()

    println("changing staff")
    doe.staff = CSharpProgrammer()
    println("Staff is ${doe.staff.javaClass.simpleName}")
    doe.work()
}
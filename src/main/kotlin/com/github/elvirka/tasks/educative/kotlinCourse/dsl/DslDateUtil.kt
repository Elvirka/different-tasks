package com.github.elvirka.tasks.educative.kotlinCourse.dsl

import java.util.Calendar
import com.github.elvirka.tasks.educative.kotlinCourse.dsl.DateUtil.Tense.*

fun main() {
    println(2 days ago)
    println(2 days from_now)
}

infix fun Int.days(timing: DateUtil.Tense) = DateUtil(this, timing)

class DateUtil(val number: Int, val tense: Tense) {
    enum class Tense {
        ago, from_now
    }

    override fun toString(): String {
        val today = Calendar.getInstance()

        when (tense) {
            ago -> today.add(Calendar.DAY_OF_MONTH, -number)
            from_now -> today.add(Calendar.DAY_OF_MONTH, number)
        }

        return today.time.toString()
    }
}




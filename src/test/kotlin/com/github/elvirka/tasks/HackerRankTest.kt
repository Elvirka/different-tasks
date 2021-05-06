package com.github.elvirka.tasks

import com.github.elvirka.tasks.hakerrank.countingValleys
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HackerRankTest : StringSpec() {

    init {
        "hackerrank test" {
        /*  val expected = """
                7
        """.trimIndent()*/

            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))

            val res = countingValleys(12, "DDUUDDUDUUUD")

            res shouldBe 1

            //baos.toString().trim() shouldBe expected

        }
    }
}
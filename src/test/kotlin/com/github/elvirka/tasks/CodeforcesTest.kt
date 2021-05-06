package com.github.elvirka.tasks

import com.github.elvirka.tasks.codeforces.task1489B
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CodeforcesTest : StringSpec() {

    init {
        "codeforces test" {
            val input = """
            4
            10 1 3
            7 3 2
            1 1000 1
            1000000000000 42 88
        """.trimIndent()

            val expected = """
            10
            9
            1000
            42000000000000
        """.trimIndent()

            // set stdin
            System.setIn(input.byteInputStream())
            // set stdout
            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))

            task1489B()

            baos.toString().trim() shouldBe expected

        }
    }
}
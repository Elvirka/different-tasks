package com.github.elvirka.tasks

import com.github.elvirka.tasks.codeforces.task1489A
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputOutputTest : StringSpec() {

    init {
        "codeforces test" {
            val input = """
            5
            2 4 2 4 4
        """.trimIndent()

            val expected = """
            2
            2 4
        """.trimIndent()

            // set stdin
            System.setIn(input.byteInputStream())
            // set stdout
            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))

            task1489A()

            baos.toString().trim() shouldBe expected

        }
    }
}
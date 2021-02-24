package com.github.elvirka.tasks

import com.github.elvirka.tasks.codeforces.archive.task231A
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputOutputTest {

    @Test
    fun test() {
        val input = """
            3
            1 1 0
            1 1 1
            1 0 0
        """.trimIndent()

        val expected = """
            2
        """.trimIndent()

        // set stdin
        System.setIn(input.byteInputStream())
        // set stdout
        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos))

        task231A()

        assertEquals(expected, baos.toString().trim())
    }

}
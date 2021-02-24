package com.github.elvirka.tasks

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.Socket
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class BlockingIOServerTest {
    private val wireMockServer = WireMockServer(wireMockConfig().port(2347))

    @BeforeAll
    fun init() {
        wireMockServer.start()
    }

    @BeforeEach
    fun setup() {
        stubFor(
            get(urlEqualTo(REQUESTED_RESOURCE))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withBody(RESPONSE)
                )
        )
    }

    @Test
    fun blockingIoTest(){
        val socket = Socket("localhost", wireMockServer.port())
        val ourStore = StringBuilder()
        val responseStream = socket.getInputStream()
        val reader = BufferedReader(InputStreamReader(responseStream))
        val requestStream = socket.getOutputStream()
        val writer = PrintWriter(OutputStreamWriter(requestStream))
        writer.print("GET $REQUESTED_RESOURCE HTTP/1.0\r\n\r\n")
        writer.flush()

        var line: String?
        while (reader.readLine().also { line = it } != null) {
            ourStore.append(line)
            ourStore.append(System.lineSeparator())
        }
        responseStream.close()
        requestStream.close()
        writer.close()
        reader.close()
        socket.close()
        assertTrue(
            ourStore
                .toString()
                .contains("It worked!")
        )
    }

    @Test
    fun blockingIoUseTest() {
        val socket = Socket("localhost", wireMockServer.port())
        val ourStore = StringBuilder()
        socket.getInputStream()
            .bufferedReader().use {
                reader ->
                socket.getOutputStream().writer().use {
                    request ->
                    PrintWriter(request).use {
                        writer ->
                        writer.print("GET $REQUESTED_RESOURCE HTTP/1.0\r\n\r\n")
                        writer.flush()
                        var line: String?
                        while (reader.readLine().also { line = it } != null) {
                            ourStore.append(line)
                            ourStore.append(System.lineSeparator())
                        }
                    }
                }
            }
        assertTrue(
            ourStore
                .toString()
                .contains("It worked!")
        )
    }

    companion object {
        const val REQUESTED_RESOURCE = "/test.json"

        const val RESPONSE = """{ "response" : "It worked!" }"""

    }

}
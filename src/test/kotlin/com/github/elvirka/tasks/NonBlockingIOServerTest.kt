package com.github.elvirka.tasks

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.StringBuilder
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.CharBuffer
import java.nio.channels.SocketChannel
import java.nio.charset.StandardCharsets
import java.nio.charset.CharsetDecoder

class NonBlockingIOServerTest {
    private val wireMockServer = WireMockServer(WireMockConfiguration.wireMockConfig().port(2347))

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
    fun nonBlockingIoTest(){
        val address = InetSocketAddress("localhost", wireMockServer.port())
        val socketChannel = SocketChannel.open(address)
        val charset = StandardCharsets.UTF_8
       socketChannel.write(
            charset.encode(
                CharBuffer.wrap("GET $REQUESTED_RESOURCE HTTP/1.0\r\n\r\n")
            )
        )
        val byteBuffer = ByteBuffer.allocate(8192)
        val charBuffer = CharBuffer.allocate(8192)
        val charsetDecoder = charset.newDecoder()
        val ourStore = StringBuilder()
        while (socketChannel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
            byteBuffer.flip()
            storeBufferContents(byteBuffer, charBuffer, charsetDecoder, ourStore)
            byteBuffer.compact()
        }
        socketChannel.close()

        assertTrue(
            ourStore
                .toString()
                .contains("It worked!")
        )
    }

    private fun storeBufferContents(
        byteBuffer: ByteBuffer?, charBuffer: CharBuffer,
        charsetDecoder: CharsetDecoder, ourStore: StringBuilder
    ) {
        charsetDecoder.decode(byteBuffer, charBuffer, true)
        charBuffer.flip()
        ourStore.append(charBuffer)
        println(ourStore.toString())
        charBuffer.clear()
    }

    companion object {
        const val REQUESTED_RESOURCE = "/test.json"

        const val RESPONSE = """{ "response" : "It worked!" }"""

    }

}
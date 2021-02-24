package com.github.elvirka.tasks.nettyIA.echoClient

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import java.net.InetSocketAddress
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.EventLoopGroup
import io.netty.channel.socket.SocketChannel


fun main() {
    val host = "localhost"
    val port = 8090
    EchoClient(host, port).start()
}

class EchoClient(private val host: String, private val port: Int) {

    fun start() {
        val group: EventLoopGroup = NioEventLoopGroup()
        try {
            val b = Bootstrap()
            b.group(group)
                .channel(NioSocketChannel::class.java)
                .remoteAddress(InetSocketAddress(host, port))
                .handler(object : ChannelInitializer<SocketChannel>() {

                    override fun initChannel(ch: SocketChannel) {
                        ch.pipeline().addLast(
                            EchoClientHandler()
                        )
                    }
                })
            val f: ChannelFuture = b.connect().sync()
            f.channel().closeFuture().sync()
        } finally {
            group.shutdownGracefully().sync()
        }
    }
}

package com.github.elvirka.tasks.nettyIA.echoServer

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import java.net.InetSocketAddress

fun main() {
    val port = 8090
    EchoServer(port).start()
}

class EchoServer(private val port: Int) {

     fun start() {
        val serverHandler = EchoServerHandler()
        val group = NioEventLoopGroup()
        try {
            val b = ServerBootstrap()
            b.group(group)
                .channel(NioServerSocketChannel::class.java)
                .localAddress(InetSocketAddress(port))
                .childHandler(object : ChannelInitializer<SocketChannel>() {
                    override fun initChannel(ch: SocketChannel) {
                            ch.pipeline().addLast(serverHandler)
                    }
                })
            val f: ChannelFuture = b.bind().sync()
            println(
                "${EchoServer::class.java.name} started and listening for connections on ${f.channel().localAddress()}"
            )
            f.channel().closeFuture().sync()
        } finally {
            group.shutdownGracefully().sync()
        }
    }
}
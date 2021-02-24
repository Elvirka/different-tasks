package com.github.elvirka.tasks.nettyIA.echoClient

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.util.CharsetUtil

@ChannelHandler.Sharable
class EchoClientHandler : SimpleChannelInboundHandler<ByteBuf>() {

    override fun channelActive(ctx: ChannelHandlerContext) {
        ctx.writeAndFlush(
            Unpooled.copiedBuffer(
                "Once you compile Kotlin code to bytecode, you can use the .class files and JAR files created from Kotlin source files in Java projects. Alternatively, you may also intermix Kotlin source files, side by side, with Java source files and call Kotlin code from within Java code. We’ve already seen the mechanics to make this work. Let’s now focus on the issues with source code we may run into with such integration efforts.",
                CharsetUtil.UTF_8
            )
        )
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: ByteBuf) {
        println("Client received: " + msg.toString(CharsetUtil.UTF_8))
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        cause.printStackTrace()
        ctx.close()
    }
}
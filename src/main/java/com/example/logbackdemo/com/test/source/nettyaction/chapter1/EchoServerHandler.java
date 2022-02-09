package com.example.logbackdemo.com.test.source.nettyaction.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.tomcat.util.buf.CharsetUtil;

import java.nio.charset.StandardCharsets;

/**
 * @program: netty-demo
 * @description:
 * @ClassName：EchoServerHandler
 * @author: Mr.Wang
 * @create: 2022-01-14 16:05
 **/
@ChannelHandler.Sharable // 标示一个ChannelHandler可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf inB = (ByteBuf) msg;
        System.out.println("Server received:" + inB.toString(StandardCharsets.UTF_8)); //打印消息
        ctx.write(inB);//将接收到的消息写给发送者，而不冲刷出站消息
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);//将未决消息冲刷到远程节点，并且关闭该Channel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

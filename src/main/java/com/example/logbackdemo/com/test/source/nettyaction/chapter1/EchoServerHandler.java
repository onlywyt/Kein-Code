package com.example.logbackdemo.com.test.source.nettyaction.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
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
        System.out.println("获取到与ChannelHandlerContext相关联的ChannelPipeline 的引用:"+ctx.pipeline());
        Channel channel = ctx.channel();//获取与ChannelContext相关的Channel的引用
        System.out.println("获取到与ChannelHandlerContext相关联的Channel 的引用: "+channel);
        ctx.writeAndFlush(inB);//将接收到的消息写给发送者，而不冲刷出站消息
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);//将未决消息冲刷到远程节点，并且关闭该Channel
    }

    /**
     * 基本的入站异常处理
     * @param ctx
     * @param cause
     * @throws Exception
     * 默认实现是简单地将当前异常转发给ChannelPipeline中的下一个ChannelHandler；
     * 如果异常到达了ChannelPipeline的尾部，它将会被记录为未处理
     * 要想定义自定义的处理逻辑，你需要重写exceptionCaught()方法。然后你需要决定是否需要将该异常传播出去。
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

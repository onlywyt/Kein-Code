package com.concurrent.source.nettyaction.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

/**
 * @program: netty-demo
 * @description:
 * @ClassName：EchoClientHandler
 * @author: Mr.Wang
 * @create: 2022-01-14 16:30
 **/
@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("获取到与ChannelHandlerContext相关联的ChannelPipeline 的引用:"+ctx.pipeline());
        System.out.println(" 获取到与ChannelHandlerContext相关联的Channel 的引用:"+ctx.channel());
        //当被通知Channel是活跃的时候，发送一条消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("媳妇，你真棒啊！！", StandardCharsets.UTF_8));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        //记录已接收消息的转储
        System.out.println("Client received:" + msg.toString(StandardCharsets.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//←--  在发生异常时，记录错误并关闭Channel
        ctx.close();
    }
}

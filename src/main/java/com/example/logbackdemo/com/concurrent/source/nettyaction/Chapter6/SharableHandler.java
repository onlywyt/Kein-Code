package com.example.logbackdemo.com.test.source.nettyaction.Chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program: source-demo
 * @description:
 * @ClassName：SharableHandler
 * @author: Mr.Wang
 * @create: 2022-02-18 15:25
 **/
@ChannelHandler.Sharable
public class SharableHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Channel read message:" + msg);
        ctx.fireChannelRead(msg);//记录方法调用，并转发给下一个ChannelHandler
    }
}

package com.example.logbackdemo.com.test.source.nettyaction.Chapter6;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @program: source-demo
 * @description:
 * @ClassName：WriteHandler
 * @author: Mr.Wang
 * @create: 2022-02-18 15:03
 **/
public class WriteHandler extends ChannelHandlerAdapter {

    private ChannelHandlerContext ctx;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;//存储到ChannelHandlerContext的引用以供稍后使用
    }
    public void sendMsg(String msg){
        ctx.writeAndFlush(msg);
    }
}

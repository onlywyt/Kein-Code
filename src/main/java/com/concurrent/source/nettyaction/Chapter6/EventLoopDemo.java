package com.concurrent.source.nettyaction.Chapter6;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：EventLoopDemo
 * @author: Mr.Wang
 * @create: 2022-02-18 16:45
 **/
public class EventLoopDemo {

    public static void main(String[] args) {

        ChannelFuture future = null;
        Channel channel = future.channel();
        channel.eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("123213");
            }
        },6, TimeUnit.SECONDS);
    }

}

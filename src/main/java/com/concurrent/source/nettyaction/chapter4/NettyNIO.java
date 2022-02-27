package com.concurrent.source.nettyaction.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @program: netty-demo
 * @description:
 * @ClassName：NettyNIO
 * @author: Mr.Wang
 * @create: 2022-01-17 13:59
 **/
public class NettyNIO {

    public void serve(int port){
        try {
            final ByteBuf buf = Unpooled.copiedBuffer("Hi!\r\n",CharsetUtil.UTF_8);
            EventLoopGroup loopGroup = new NioEventLoopGroup();//使用NIO非阻塞模式
            ServerBootstrap bootstrap = new ServerBootstrap().group(loopGroup);
            bootstrap.channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(buf.duplicate())
                                            .addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }

    }
}

package com.example.logbackdemo.com.test.source.nettyaction.chapter1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @program: netty-demo
 * @description: NettyAction服务端实例代码
 * @ClassName：NettyServer
 * @author: Mr.Wang
 * @create: 2022-01-14 16:01
 **/
public class EchoNettyServer {
    private final int port;

    public EchoNettyServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new EchoNettyServer(9999).start();
    }

    private void start() throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();//创建Event-LoopGroup;使用NIO传输所以是NioEventLoopGroup
        try {
            ServerBootstrap b = new ServerBootstrap()
                    .group(eventLoopGroup)//创建Server-Bootstrap
                    .channel(NioServerSocketChannel.class)//指定所使用的的NIO传输channel
                    .localAddress(new InetSocketAddress(port))//使用指定d的端口设置套接字地址
                    .childHandler(new ChannelInitializer() {//添加一个EchoServerHandler到子Channel的ChannlePipeline
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);//echoServerHandler被标注为@Shareable，所以我们可以使用同样的实例

                        }
                    });
            ChannelFuture future = b.bind().sync();//异步绑定服务器，调用sync()方法阻塞等待直到完成
            future.channel().closeFuture().sync();//获取Channel的CloseFuture方法，并阻塞当前线程直到它完成
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully().sync();//关闭EventLoopGroup，释放所有资源
        }
    }
}

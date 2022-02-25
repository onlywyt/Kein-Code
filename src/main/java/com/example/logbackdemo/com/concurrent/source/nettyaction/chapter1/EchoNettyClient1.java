package com.example.logbackdemo.com.test.source.nettyaction.chapter1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @program: source-demo
 * @description:
 * @ClassName：EchoNettyClient1
 * @author: Mr.Wang
 * @create: 2022-02-18 17:27
 **/
public class EchoNettyClient1 {

    private final  String host;
    private final  int port;

    public EchoNettyClient1(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws  Exception{
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //使用NIO传输，创建EventLoopGroup
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))//为服务器创建一个InetSocketAddress实例
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //当连接被建立时，一个EchoClientHandler实例会被安装到（该Channel的）ChannelPipeline中；
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture f = b.connect().sync();//当一切设置完成后，Bootstrap.connect()连接到远程节点
            /**
             * 添加ChannelFutureListener到ChannelFuture.
             * 它将打印栈跟踪信息并且随后关闭Channel。
             */
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()){
                    System.out.println("连接成功");
                } else {
                    future.cause().printStackTrace();
                    future.channel().close();
                }
            });
            f.channel().closeFuture().sync();
        } finally {
            //优雅退出Netty
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoNettyClient("127.0.0.1",9999).start();
    }
}


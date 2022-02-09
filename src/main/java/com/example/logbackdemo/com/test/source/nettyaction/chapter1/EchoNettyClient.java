package com.example.logbackdemo.com.test.source.nettyaction.chapter1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @program: netty-demo
 * @description: NettyAction客户端实例代码
 * @ClassName：NettyClioent
 * @author: Mr.Wang
 * @create: 2022-01-14 16:01
 **/
public class EchoNettyClient {
    private final  String host;
    private final  int port;

    public EchoNettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws  Exception{
        EventLoopGroup group = new NioEventLoopGroup(); //使用NIO传输，创建EventLoopGroup
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
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
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoNettyClient("127.0.0.1",9999).start();
    }
}

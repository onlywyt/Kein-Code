package com.concurrent.source.nettyaction.chapter1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
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
public class
EchoNettyServer {
    private final int port;

    public EchoNettyServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new EchoNettyServer(9991).start();
    }

    private void start() throws Exception {
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(6);
        try {
            ServerBootstrap b = new ServerBootstrap()
                    .group(bossEventLoopGroup)//设置EventLoopGroup，其提供了用于处理Channel 事件的EventLoop
                    .channel(NioServerSocketChannel.class)//指定所使用的的NIO传输channel
                    .localAddress(new InetSocketAddress(port))//使用指定d的端口设置套接字地址
                    .childHandler(new ChannelInitializer() {//添加一个EchoServerHandler到子Channel的ChannlePipeline
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(echoServerHandler);//echoServerHandler被标注为@Shareable，所以我们可以使用同样的实例

                        }
                        //可以通过调小TCP的接收和发送缓冲区来降低单个TCP连接的资源占用率例如将收发缓冲区设置为8KB ，
                    }).childOption(ChannelOption.SO_RCVBUF,8 * 1024)
                    .childOption(ChannelOption.SO_SNDBUF,8 * 1024);
            ChannelFuture future = b.bind().sync();//异步绑定服务器，调用sync()方法阻塞等待直到完成

            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()){
                        System.out.println("Server bound");
                    } else {
                        System.out.println("Bound attempt failed");
                        future.channel().close();
                    }
                }
            });
           //Netty通过Channel的EventLoop实现任务调度解决了这一问题；调度在6秒之后，并且以后每间隔6秒运行；
//            future.channel().eventLoop().scheduleAtFixedRate(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("123213");
//                }
//            },6, 6,TimeUnit.SECONDS);

            future.channel().closeFuture().sync();//获取Channel的CloseFuture方法，并阻塞当前线程直到它完成
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            bossEventLoopGroup.shutdownGracefully().sync();//关闭EventLoopGroup，释放所有资源
        }
    }
}

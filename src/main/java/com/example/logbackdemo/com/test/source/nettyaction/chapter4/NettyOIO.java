package com.example.logbackdemo.com.test.source.nettyaction.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @program: netty-demo
 * @description:
 * @ClassName：NettyOIO
 * @author: Mr.Wang
 * @create: 2022-01-17 13:49
 **/
public class NettyOIO {
    public void server(int port){
        ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(("HI!\r\n"), CharsetUtil.UTF_8));
        EventLoopGroup loopGroup = new OioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap().group(loopGroup);
            //使用OioServerSocketChannel阻塞IO模式
            serverBootstrap.channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    //指定ChannelInitializer，对于每个已接收的连接都调用它
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //ChannelInboundHandlerAdapter：拦截和处理程序业务逻辑
                                 ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                     @Override
                                     public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                         //将消息写回服务器，ChannelFutureListener代表消息写完就关闭连接
                                         ctx.writeAndFlush(buf.duplicate())
                                                 .addListener(ChannelFutureListener.CLOSE);
                                     }
                                 });
                        }
                    });
            ChannelFuture future = serverBootstrap.bind().sync();//异步绑定服务器
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            loopGroup.shutdownGracefully();//释放资源
        }
    }
}

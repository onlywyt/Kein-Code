package com.concurrent.source.nettyaction.chapter5;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ByteBufDemo
 * @author: Mr.Wang
 * @create: 2022-02-16 21:58
 **/
public class ByteBufDemo {

    public static void main(String[] args) {
        //demo1();

        //demo2();

        //以十六进制的表示形式打印ByteBuf的内容
        String s = ByteBufUtil.hexDump(Unpooled.copiedBuffer("Netty in action!!!".getBytes(StandardCharsets.UTF_8)));
        System.out.println(s);
    }

    private static void demo2() {
        Charset charset = Charset.forName("UTF-8");
        //创建一个新的ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty in action!!!", charset);
        //输出第一个字符；N
        System.out.println((char)byteBuf.getByte(0));
        //存储当前的readIndex和writeIndex
        int readerIndex = byteBuf.readerIndex();
        System.out.println(readerIndex);
        int writerIndex = byteBuf.writerIndex();
        System.out.println(writerIndex);
        //将索引0处的字符修改为B
        byteBuf.setByte(0, (byte)'B');
        //输出第一个字符；B
        System.out.println((char)byteBuf.getByte(0));
        //以下比较返回true，因为上述操作不会修改相应索引
        System.out.println(readerIndex == byteBuf.readerIndex());
        System.out.println(writerIndex == byteBuf.writerIndex());
        System.out.println(byteBuf.readBoolean());
        System.out.println(byteBuf.readerIndex());
    }

    private static void demo1() {
        ByteBuf buffer = Unpooled.buffer(256);
        ByteBuf byteBuf = buffer.writeChar(123);
        System.out.println(byteBuf.getByte(0));
        if (buffer.hasArray()){
            byte[] array = buffer.array();
            int offset = buffer.arrayOffset() + buffer.readerIndex();
            int length = buffer.readableBytes();
            handleArray(array,offset,length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {

    }
}

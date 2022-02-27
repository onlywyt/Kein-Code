package com.concurrent.source.thread.safety.queue;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ProduceAndConsumerProgram
 * @author: Mr.Wang
 * @create: 2022-01-21 16:41
 **/

@Slf4j
public class ProduceAndConsumerProgram {

    static Logger logger = LoggerFactory.getLogger(ProduceAndConsumerProgram.class);

    static class Producer implements Runnable{
        BlockingQueue<String> blockingQueue;
        public Producer(BlockingQueue<String> blockingQueue){
            this.blockingQueue=blockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.put("element:" + i);
                    logger.info("{},生产者生产数据，目前总的元素个数:{}",Thread.currentThread().getName(),blockingQueue.size());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        BlockingQueue<String> blockingQueue;
        public Consumer(BlockingQueue<String> blockingQueue){
            this.blockingQueue=blockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    String element=blockingQueue.take();//通过阻塞特性获取元素的方法取数据
                    logger.info("{},消费者消费数据，目前还剩下的元素个数:{}", Thread.currentThread().getName(),blockingQueue.size());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)throws InterruptedException {
        BlockingQueue<String> blockingQueue=new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        Thread.sleep(1000);
        new Thread(consumer).start();
    }
}

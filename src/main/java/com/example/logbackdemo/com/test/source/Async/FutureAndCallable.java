package com.example.logbackdemo.com.test.source.Async;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @program: source-demo
 * @description:
 * @ClassName：FutureAndCallable
 * @author: Mr.Wang
 * @create: 2022-02-09 14:51
 **/
public class FutureAndCallable {

    //定义了一个具有返回值的任务
    static class CalculationCallable implements Callable<Integer> {
        private int x;
        private int y;
        public CalculationCallable(int x, int y){
            this.x = x;
            this.y = y;
        }
        //Treiber Stack

        @Override
        public Integer call() throws Exception {
            System.out.println("begin call:" + new Date());
            TimeUnit.SECONDS.sleep(2);
            return x + y;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CalculationCallable calculationCallable = new CalculationCallable(1,2);
        //用FutureTask声明一个带有返回值的任务,把CalculationCallable当做参数传进去
        FutureTask<Integer> futureTask = new FutureTask<>(calculationCallable);
        //把futureTask丢给线程去执行
        new Thread(futureTask).start();
        System.out.println("begin execute futureTask:" +new Date());
        //使用futureTask.get()获取返回值，同步阻塞方法
        Integer result = futureTask.get();
        System.out.println("result:"+result+"");
        System.out.println("end execute futureTask:" + new Date());
    }
}

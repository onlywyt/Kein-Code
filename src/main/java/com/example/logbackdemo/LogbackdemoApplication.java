package com.example.logbackdemo;

import com.example.logbackdemo.com.spring.evevt.MyEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class LogbackdemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(LogbackdemoApplication.class);


    @GetMapping("/loop")
    public String dumpWhile(){
        new Thread(new WhileThrad()).start();
        return "ok";
    }

    class WhileThrad implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println("Thread");
            }
        }
    }

    @GetMapping("/dead")
    public String dumpDeadLock(){
        Thread a = new Thread();
        Thread b = new Thread();
        a.start();
        b.start();
        return "ok";
    }


    class ThradRunA extends Thread{
        @Override
        public void run() {
            System.out.println("=============A=============");
            synchronized (ThradRunA.class){
                System.out.println("开始执行A。。。"+Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (ThreadRunB.class){
                    System.out.println("我在执行任务结束了A。。。" + Thread.currentThread().getName()+":"
                            + ThreadRunB.class.hashCode() +":" + ThradRunA.class.hashCode());
                }
            }
        }
    }

    class ThreadRunB extends Thread {
        @Override
        public void run() {
            System.out.println("================B===================");
            synchronized(ThreadRunB.class) {
                System.out.println("我要开始执行任务B..." + Thread.currentThread().getName());
                try { Thread.sleep(1000);
                }catch(InterruptedException e) { e.printStackTrace();  }
                synchronized(ThradRunA.class) {

                }
                System.out.println("我在执行任务结束了B..." + Thread.currentThread().getName() + ":" +
                        ThreadRunB.class+ ":" +ThradRunA.class);
         }
     }}





    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("index");
        logger.info("logback整合成功了");
        logger.error("logback整合成功了");
        return mav;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LogbackdemoApplication.class, args);
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        publisher.publishEvent();
    }

}

package com.concurrent.source.thread.lockdemo.waitandnotifydemo;

/**
 * @program: source-demo
 * @description:
 * @ClassName：ProduceAndConsumer
 * @author: Mr.Wang
 * @create: 2022-02-22 16:12
 **/
public class ProduceAndConsumer {

    static class CarStock {
        int cars;

        public synchronized void productCar() {
            try {
                if (cars < 20) {
                    System.out.println("生产车..." + cars);
                    Thread.sleep(100);
                    cars++;
                    notifyAll();
                } else {
                    wait();
                }
            } catch (Exception e) {

            }
        }


        public synchronized void consumerCar() {
            try {
                if (cars > 0) {
                    System.out.println("销售车..." + cars);
                    Thread.sleep(100);
                    cars--;
                    notifyAll();
                } else {
                    wait();
                }
            } catch (Exception e) {

            }
        }
    }

    static class CarConsumer implements Runnable {
        CarStock carStock;

        public CarConsumer(CarStock carStock) {
            this.carStock = carStock;
        }

        @Override
        public void run() {
            while (true) {
                carStock.consumerCar();//消费车
            }
        }
    }

    static class CarProducer implements Runnable {
        CarStock carStock;

        public CarProducer(CarStock carStock) {
            this.carStock = carStock;
        }

        @Override
        public void run() {
            while (true) {
                carStock.productCar();
            }
        }
    }

    public static void main(String[] args) {
        CarStock carStock = new CarStock();
        CarProducer carProducer = new CarProducer(carStock);
        CarConsumer carConsumer = new CarConsumer(carStock);

        Thread t1 = new Thread(carProducer);
        Thread t2 = new Thread(carProducer);
        Thread t3= new Thread(carConsumer);
        Thread t4 = new Thread(carConsumer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

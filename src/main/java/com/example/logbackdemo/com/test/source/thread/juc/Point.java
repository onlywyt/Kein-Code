package com.example.logbackdemo.com.test.source.thread.juc;

import java.util.concurrent.locks.StampedLock;

/**
 * @program: source-demo
 * @description: StampedLock demo
 * @ClassName：Point
 * @author: Mr.Wang
 * @create: 2022-01-27 13:26
 **/
public class Point {
    private double x,y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY){
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    double distance(){
        long stamp = sl.tryOptimisticRead();
        double currentX = x,currentY = y;
        if (!sl.validate(stamp)){
            stamp = sl.readLock();
            try {
                currentX =x;
                currentY=y;
            }finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentY * currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY){
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0){
                long ws = sl.tryConvertToWriteLock(stamp);//将读锁转化为写锁
                if (ws != 0L){
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }else {
                    sl.unlockRead(stamp);
                    stamp=sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}

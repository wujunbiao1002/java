package com.wjb.java.juc.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class NotifyWaitDemo2 {
    public static void main(String[] args) {
        ShareDataTow sd = new ShareDataTow();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    sd.increment();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    sd.decrement();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    sd.increment();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    sd.decrement();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

//资源类
class ShareDataTow {
    private int number = 0;//初始值为零的一个变量
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //1判断
            while (number != 0) {
                condition.await();
            }
            //2干活
            ++number;
            System.out.println(Thread.currentThread().getName() + "\t+" + number);
            //3通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            // 1判断
            while (number == 0) {
                condition.await();
            }
            // 2干活
            --number;
            System.out.println(Thread.currentThread().getName() + "\t-" + number);
            // 3通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


package com.wjb.java.juc.lock.support;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LockSupportDemo {
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t ----come in" + System.currentTimeMillis());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t ----被唤醒" + System.currentTimeMillis());
        }, "t1");
        t1.start();

        //暂停几秒钟线程
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(() -> {
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t ----发出通知");
        }, "t2").start();

    }
    @Test
    public void lockAwaitSignalTest() {
        lockAwaitSignal();
    }

    @Test
    public void syncWaitNotifyTest() {
        syncWaitNotify();
    }

    /**
     * condition.await();和 condition.signal();都触发了 IllegalMonitorStateException异常。
     * 结论： lock、unlock对里面才能正确调用调用condition中线程等待和唤醒的方法
     * Condtion中的线程等待和唤醒方法之前，需要先获取锁
     * 一定要先await后signal，不要反了
     */
    private static void lockAwaitSignal() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(Thread.currentThread().getName() + "\t ----come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t ----被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t ----发出通知");
            } finally {
                lock.unlock();
            }
        }, "t2").start();
        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
    }


    /**
     * 要求：t1线程等待3秒钟，3秒钟后t2线程唤醒t1线程继续工作
     * <p>
     * 1 正常程序演示
     * <p>
     * 以下异常情况：
     * 2 wait方法和notify方法，两个都去掉同步代码块后看运行效果
     * 2.1 异常情况
     * Exception in thread "t1" java.lang.IllegalMonitorStateException at
     * java.lang.Object.wait(Native Method)
     * Exception in thread "t2" java.lang.IllegalMonitorStateException at
     * java.lang.Object.notify(Native Method)
     * 2.2 结论
     * Object类中的wait、notify、notifyAll用于线程等待和唤醒的方法，都必须在synchronized
     * 内部执行（必须用到关键字synchronized）。
     * <p>
     * 3 将notify放在wait方法前面
     * 3.1 程序一直无法结束
     * 3.2 结论
     * 先wait后notify、notifyall方法，等待中的线程才会被唤醒，否则无法唤醒
     */
    private static void syncWaitNotify() {
        Object objectLock = new Object();

        new Thread(() -> {
            synchronized (objectLock) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t ----come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t ----被唤醒");
            }
        }, "t1").start();

        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t ----发出通知");
            }
        }, "t2").start();
        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

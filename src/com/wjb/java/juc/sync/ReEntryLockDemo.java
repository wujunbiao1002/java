package com.wjb.java.juc.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized
 * lock
 * 可重入锁操作
 */
public class ReEntryLockDemo {
    public synchronized void m1() {
        //指的是可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
        System.out.println(Thread.currentThread().getName() + "\t ----come in m1");
        m2();
        System.out.println(Thread.currentThread().getName() + "\t ----end m1");
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "\t ----come in m2");
        m3();
    }

    public synchronized void m3() {
        System.out.println(Thread.currentThread().getName() + "\t ----come in m3");
    }

    static Lock lock = new ReentrantLock();

    public void m4() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t ----come in m4");
        m5();
        lock.unlock();
    }

    public void m5() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t ----come in m5");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        // synchronizedc可重入锁
        ReEntryLockDemo reEntryLockDemo = new ReEntryLockDemo();
        new Thread(reEntryLockDemo::m1, "t1").start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("------------------------");
        // lock可重入锁
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t ----come in外层调用");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t ----come in内层调用");
                } finally {
                    lock.unlock();
                }
            } finally {
                // 由于加锁次数和释放次数不一样，第二个线程始终无法获取到锁，导致一直在等待。
                lock.unlock();// 正常情况，加锁几次就要解锁几次
            }
        }, "t1").start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("------------------------");
        new Thread(() -> {
            lock.lock();
            try {
                reEntryLockDemo.m4();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    private static void reEntryM1() {
        final Object object = new Object();

        new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "\t ----外层调用");
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "\t ----中层调用");
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + "\t ----内层调用");
                    }
                }
            }
        }, "t1").start();
    }
}

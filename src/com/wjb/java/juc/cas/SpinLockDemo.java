package com.wjb.java.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 题目：实现一个自旋锁
 * 自旋锁好处：循环比较获取没有类似wait的阻塞。
 * <p>
 * 通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒钟，B随后进来后发现
 * 当前有线程持有锁，不是null，所以只能通过自旋等待，直到A释放锁后B随后抢到。
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void tryLock() {
        System.out.println(Thread.currentThread().getName() + "\t tryLock in");
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
            System.out.println(Thread.currentThread().getName() + "\t tryLock 失败");

        }
        System.out.println(Thread.currentThread().getName() + "\t tryLock 成功");
    }

    public void tryUnLock() {
        System.out.println(Thread.currentThread().getName() + "\t tryUnLock in");
        boolean b = atomicReference.compareAndSet(Thread.currentThread(), null);
        if (b) {
            System.out.println(Thread.currentThread().getName() + "\t tryUnLock 成功");
        }

    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.tryLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.tryUnLock();
        }, "A").start();

        //暂停一会儿线程，保证A线程先于B线程启动并完成
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.tryLock();
            spinLockDemo.tryUnLock();
        }, "B").start();
    }
}
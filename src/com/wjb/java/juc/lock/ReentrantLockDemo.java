package com.wjb.java.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        LockRunnable lockRunnable = new LockRunnable();
        Thread thread1 = new Thread(lockRunnable);
        Thread thread2 = new Thread(lockRunnable);
        Thread thread3 = new Thread(lockRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class LockRunnable implements Runnable {
    private int num = 100;
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    LockRunnable() {
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
                // 1
                reentrantLock.lock();
                // 2
                reentrantLock.tryLock();
                // 3
                reentrantLock.tryLock(1, TimeUnit.SECONDS);
                // 4
                reentrantLock.lockInterruptibly();
                if (num > 0){
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num--;
                }else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
                reentrantLock.unlock();
                reentrantLock.unlock();
                reentrantLock.unlock();
            }
        }
    }
}
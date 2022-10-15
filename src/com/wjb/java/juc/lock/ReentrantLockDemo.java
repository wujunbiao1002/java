package com.wjb.java.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <b><code>MyLock</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/17 22:55.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
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
                reentrantLock.lock();
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
            }
        }
    }
}
package com.wjb.java.juc.thread.communication;

/**
 *
 */
public class NotifyWaitDemo1 {
    public static void main(String[] args) {
        ShareData sd = new ShareData();
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
//        new Thread(() -> {
//            for (int i = 1; i < 10; i++) {
//                try {
//                    sd.increment();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }, "C").start();
//        new Thread(() -> {
//            for (int i = 1; i < 10; i++) {
//                try {
//                    sd.decrement();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }, "D").start();
    }
}

//资源类
class ShareData {
    private int number = 0;//初始值为零的一个变量

    public synchronized void increment() throws InterruptedException {
        //1判断
        if (number != 0) {
            this.wait();
        }
        //2干活
        ++number;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //3通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 1判断
        if (number == 0) {
            this.wait();
        }
        // 2干活
        --number;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 3通知
        this.notifyAll();
    }
}

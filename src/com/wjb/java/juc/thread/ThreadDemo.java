package com.wjb.java.juc.thread;

/**
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
            if (i ==20){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread extends Thread {
    public MyThread() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}
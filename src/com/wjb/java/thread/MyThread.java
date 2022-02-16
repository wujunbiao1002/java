package com.wjb.java.thread;

/**
 * <b><code>Test1</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/16 15:29.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class MyThread {
    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
            if (i ==20){
                try {
                    threadTest1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class ThreadTest1 extends Thread {
    public ThreadTest1() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);

        }
    }
}
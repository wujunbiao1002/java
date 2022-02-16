package com.wjb.java.thread;

/**
 * <b><code>MyRunnable</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/16 15:44.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class MyRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest());
        thread.start();
    }
}

class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
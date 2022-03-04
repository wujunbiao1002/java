package com.wjb.java.thread;

/**
 * <b><code>Communication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/17 23:19.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        Thread thread3 = new Thread(number);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Number implements Runnable {

    private int num = 1;
    private Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (num < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

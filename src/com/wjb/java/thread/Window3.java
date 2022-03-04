package com.wjb.java.thread;

/**
 * <b><code>Window</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/17 11:21.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Window3 {
    public static void main(String[] args) {
        Thread thread1 = new WindowThread3();
        Thread thread2 = new WindowThread3();
        Thread thread3 = new WindowThread3();

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowThread3 extends Thread {
    private static int num = 100;

    WindowThread3() {
    }

    @Override
    public void run() {
//        fun();
        fun2();
    }

    /**
     * 所有静态方法共用同一把锁：类名.class
     */
    synchronized public static void fun() {
        while (num > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-卖出票号:" + num);
            num--;
        }
    }

    /**
     * 所有非静态方法共用同一把this锁
     */
    synchronized public void fun2() {
        while (num > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-卖出票号:" + num);
            num--;
        }
    }
}

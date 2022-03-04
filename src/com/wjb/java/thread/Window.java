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
public class Window {
    public static void main(String[] args) {
        WindowThread windowThread = new WindowThread();
        Thread thread1 = new Thread(windowThread);
        Thread thread2 = new Thread(windowThread);
        Thread thread3 = new Thread(windowThread);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WindowThread implements Runnable {
    private int num = 50;

    WindowThread() {
    }

    @Override
    public void run() {
        synchronized (WindowThread.class) {
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
}

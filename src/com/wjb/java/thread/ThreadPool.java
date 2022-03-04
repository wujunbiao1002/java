package com.wjb.java.thread;

import java.util.concurrent.*;

/**
 * <b><code>ThreadPool</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/18 10:35.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future submit = executorService.submit(new NumberCallable2());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.execute(new NumberCallable3());
        executorService.shutdown();
    }
}

class NumberCallable2 implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

class NumberCallable3 implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
    }
}

package com.wjb.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <b><code>MyCallable</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/18 10:09.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class MyCallable {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new NumberCallable());
        new Thread(futureTask).start();

        try {
            Integer num = futureTask.get();
            System.out.println(num);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumberCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

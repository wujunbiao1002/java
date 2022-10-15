package com.wjb.java.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 */
public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();

        try {
            Integer num = futureTask.get();
            System.out.println(num);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable {

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

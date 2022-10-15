package com.wjb.java.juc.future;

import java.util.concurrent.*;

/**
 *
 */
public class FutureTaskThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3个任务，目前开启多个异步任务线程来处理，请问耗时多少？

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over";
        });

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over";
        });

        // 启动任务
        threadPool.submit(futureTask1);
        threadPool.submit(futureTask2);

        // 获取结果
        // get方法是阻塞式的
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: " + (endTime - startTime) + " 毫秒");

        System.out.println(Thread.currentThread().getName() + "\t -----end");
        threadPool.shutdown();
    }
}

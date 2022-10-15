package com.wjb.java.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * handle有异常，在执行完handle链路之后直接执行exceptionally异常处理
 * handle无异常，在执行完handle链路之后直接执行whenComplete
 * handle异常情况：有异常也可以往下一步走，根据带的异常参数可以进一步处理
 */
public class CompletableFutureAPI2Demo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            return 1;
        }, threadPool).handle((f, e) -> {
            System.out.println("222");
            return f + 3;
        }).handle((f, e) -> {
            int i = 10 / 0; // 抛出异常
            System.out.println("333");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("444");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("----计算结果： " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "----主线程先去忙其它任务");

        threadPool.shutdown();
    }
}

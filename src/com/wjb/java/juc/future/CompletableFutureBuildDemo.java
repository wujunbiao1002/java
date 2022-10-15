package com.wjb.java.juc.future;

import java.util.concurrent.*;

/**
 *
 */
public class CompletableFutureBuildDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            //暂停几秒钟线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        },threadPool);

        System.out.println(completableFuture.get());*/

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            //暂停几秒钟线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            return "hello supplyAsync";
        },threadPool);
        System.out.println(completableFuture.get());

        threadPool.shutdown();
    }
}

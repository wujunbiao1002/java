package com.wjb.java.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 */
public class CompletableFutureAPI1Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        group1();
    }

    /**
     * 获得结果和触发计算
     *
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    private static void group1() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        System.out.println(Thread.currentThread().getName()+"\t"+completableFuture.get());
        System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
        System.out.println(completableFuture.join());

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(completableFuture.getNow("xxx"));
        // 如果任务没有计算完成complete，非阻塞直接返回指定的值
        System.out.println(completableFuture.complete("completeValue") + "\t" + completableFuture.get());
    }
}

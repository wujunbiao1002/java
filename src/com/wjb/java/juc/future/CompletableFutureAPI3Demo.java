package com.wjb.java.juc.future;

import java.util.concurrent.CompletableFuture;

/**
 * 计算结果存在依赖关系，这两个线程串行化
 * 由于存在依赖关系(当前步错，不走下一步)，当前步骤有异常的话就叫停。
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).thenAccept(System.out::println);

        // thenRun
        // thenRun(Runnable runnable)
        // 任务 A 执行完执行 B，并且 B 不需要 A 的结果
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {
        }).join());
        // thenAccept
        // thenAccept(Consumer action)
        // 任务 A 执行完执行 B，B 需要 A 的结果，但是任务 B 无返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(System.out::println).join());
        // thenApply
        // thenApply(Function fn)
        // 任务 A 执行完执行 B，B 需要 A 的结果，同时任务 B 有返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());

    }
}
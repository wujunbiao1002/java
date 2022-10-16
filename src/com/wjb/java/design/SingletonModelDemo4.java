package com.wjb.java.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例设计模式延迟创建，懒汉式 静态内部类形式最简单
 * 适合多线程，线程安全
 */
public class SingletonModelDemo4 {
    private SingletonModelDemo4() {
    }

    private static final class Inner {
        static final SingletonModelDemo4 instance = new SingletonModelDemo4();
    }

    public static SingletonModelDemo4 getInstance() {
        return Inner.instance;
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                System.out.println(getInstance());
            });
        }
        threadPool.shutdown();
    }
}
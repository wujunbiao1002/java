package com.wjb.java.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例设计模式延迟创建，懒汉式， volatile
 * 适合多线程，线程安全,
 */
public class SingletonModelDemo3 {
    private static volatile SingletonModelDemo3 instance;
    public static int num = 1;
    private SingletonModelDemo3() {
    }

    public static SingletonModelDemo3 getInstance() {
        if (instance == null) {
            synchronized (SingletonModelDemo3.class) {
                if (instance == null) {
                    instance = new SingletonModelDemo3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                System.out.println(getInstance() +"--"+ num);
            });
        }
        threadPool.shutdown();
    }
}
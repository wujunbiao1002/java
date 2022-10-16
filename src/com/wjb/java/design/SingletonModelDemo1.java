package com.wjb.java.design;

/**
 * 单例设计模式延迟创建，懒汉式
 * 适合单线程，线程不安全
 */
public class SingletonModelDemo1 {
    private static SingletonModelDemo1 instance;

    private SingletonModelDemo1() {
    }

    public static SingletonModelDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonModelDemo1();
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
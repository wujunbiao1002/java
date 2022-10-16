package com.wjb.java.design;

/**
 * 单例设计模式，饿汉式
 * 适合单线程，线程不安全
 */
public class SingletonModelDemo2 {
    private static final SingletonModelDemo2 INSTANCE  = new SingletonModelDemo2();

    private SingletonModelDemo2() {
    }

    public static SingletonModelDemo2 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {

    }
}
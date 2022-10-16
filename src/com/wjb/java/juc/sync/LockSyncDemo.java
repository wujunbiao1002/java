package com.wjb.java.juc.sync;


/**
 *  synchronized
 *  三种方式
 *  1.代码块
 *  2.对象方法
 *  3.静态方法
 */
public class LockSyncDemo {

    final Object object = new Object();

    public void m1() {
        synchronized (object) {
            System.out.println("----hello synchronized code block");
            throw new RuntimeException("-----exp");
        }
    }

    public synchronized void m2() {
        System.out.println("----hello synchronized m2");
    }

    public static synchronized void m3() {
        System.out.println("----hello static synchronized m3");
    }


    public static void main(String[] args) {

    }
}

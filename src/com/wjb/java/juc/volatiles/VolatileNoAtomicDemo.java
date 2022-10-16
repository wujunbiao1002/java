package com.wjb.java.juc.volatiles;

import java.util.concurrent.TimeUnit;

class MyNumber {
    volatile int number;

    public void addPlusPlus() {
        number++; // 非原子操作符 1取数 2加法 3赋值
    }
}

/**
 * 可见性cas
 */
public class VolatileNoAtomicDemo {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myNumber.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myNumber.number);

    }
}

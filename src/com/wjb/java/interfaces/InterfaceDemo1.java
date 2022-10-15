package com.wjb.java.interfaces;

/**
 * <b><code>InterfaceTest1</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 18:33.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class InterfaceDemo1 {
    public static void main(String[] args) {
        Fly fly = new Fly() {
            @Override
            public void fly() {
                System.out.println("飞");
            }
        };
        fly.fly();
        method(new Fly() {
            @Override
            public void fly() {
                System.out.println("飞了？");
            }
        });
    }

    static void method(Fly fly){
        System.out.println("起飞");
        fly.fly();
    }
}

interface Fly{
    void fly();
}

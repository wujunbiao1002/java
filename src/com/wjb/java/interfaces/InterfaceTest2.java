package com.wjb.java.interfaces;

/**
 * <b><code>InterfaceTest2</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 19:10.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class InterfaceTest2 {
    public static void main(String[] args) {
//        Class2 class2 = new Class2();
//        class2.method3();
//        class2.method2();
//        Interface1.method1();
        Class4 class4 = new Class4();
        class4.method4();
    }
}

interface Interface1 {
    static void method1() {
        System.out.println("Interface1+method1");
    }

    default void method2() {
        System.out.println("Interface1+method2");
    }

    default void method3() {
        System.out.println("Interface1+method3");
    }
}

interface Interface2 {
    default void method3() {
        System.out.println("Interface2+method3");
    }
}

class Class1 {
    public void method3() {
        System.out.println("class1+method3");
    }
}

class Class2 extends Class1 implements Interface1, Interface2 { }

class Class3 extends Class1 implements Interface1, Interface2 {
    @Override
    public void method3() {
        System.out.println("class2+method3");
    }
}

class Class4 extends Class1 implements Interface1, Interface2 {
    @Override
    public void method3() {
        System.out.println("class2+method3");
    }

    public void method4(){
        super.method3();
        Interface1.super.method2();
        Interface1.super.method3();
        Interface2.super.method3();
    }
}
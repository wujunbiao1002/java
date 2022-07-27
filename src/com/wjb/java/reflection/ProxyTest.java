package com.wjb.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <b><code>ProxyTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 13:09.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);

        proxyInstance.eat("麻辣烫");

        System.out.println("---------------------");

        NickClothFactory nickClothFactory = new NickClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory)ProxyFactory.getProxyInstance(nickClothFactory);
        proxyInstance1.productCloth();

    }
}

interface Human {
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "我是超人";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃" + food);
    }
}

// AOP
class HumanUtil {
    public void method1() {
        System.out.println("====================通用方法一====================");
    }

    public void method2() {
        System.out.println("====================通用方法二====================");
    }
}

/*
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */

class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandle = new MyInvocationHandler();
        myInvocationHandle.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandle);
    }
}

class MyInvocationHandler implements InvocationHandler {
    // 需要使用被代理类的对象进行赋值
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    // 将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy代理类对象，method代理类对象调用方法，args方法参数
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object invoke = method.invoke(obj, args);
        humanUtil.method2();

        return invoke;
    }
}
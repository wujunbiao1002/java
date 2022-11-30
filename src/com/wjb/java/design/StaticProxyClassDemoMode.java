package com.wjb.java.design;

import org.junit.Test;

/**
 * <b><code>StaticProxyTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 13:03.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class StaticProxyClassDemoMode {
    @Test
    public void test(){
        NickClothFactory nickClothFactory = new NickClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nickClothFactory);
        proxyClothFactory.productCloth();
    }
}

// 公共接口
interface ClothFactory {
    void productCloth();
}

// 被代理类
class NickClothFactory implements ClothFactory {

    @Override
    public void productCloth() {
        System.out.println("Nick工厂生产一批运动服");
    }
}

// 代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理工厂准备工作");
        clothFactory.productCloth();
        System.out.println("代理工厂后续收尾工作");
    }
}
